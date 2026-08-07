package com.pengrad.telegrambot

import com.google.gson.JsonParser
import com.pengrad.telegrambot.model.request.InputMediaPhoto
import com.pengrad.telegrambot.model.request.InputMediaVoiceNote
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessageMedia
import com.pengrad.telegrambot.model.request.richmessages.inputrichblock.*
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richtext.RichTextArray
import com.pengrad.telegrambot.model.richmessages.richtext.RichTextBold
import com.pengrad.telegrambot.model.richmessages.richtext.RichTextPlain
import com.pengrad.telegrambot.request.EditMessageText
import com.pengrad.telegrambot.request.richmessages.SendRichMessage
import com.pengrad.telegrambot.request.richmessages.SendRichMessageDraft
import com.pengrad.telegrambot.utility.BotUtils
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class RichMessageRequestTest {

    private fun json(any: Any) = JsonParser.parseString(BotUtils.toJson(any)).asJsonObject

    /** Serializes the block the way a request does: as an element of [InputRichMessage.blocks]. */
    private fun blockJson(block: InputRichBlock) =
        json(InputRichMessage().blocks(block))["blocks"].asJsonArray[0].asJsonObject

    @Test
    fun `block carries its type discriminator`() {
        val block = blockJson(InputRichBlockParagraph(RichTextPlain("hi")))

        assertEquals("paragraph", block["type"].asString)
        assertEquals("hi", block["text"].asString)
    }

    @Test
    fun `every block type is serialized with the expected discriminator`() {
        val photo = InputMediaPhoto("file_id")
        val blocks = listOf(
            InputRichBlockParagraph(RichTextPlain("p")) to "paragraph",
            InputRichBlockSectionHeading(RichTextPlain("h"), 1) to "heading",
            InputRichBlockPreformatted(RichTextPlain("code")) to "pre",
            InputRichBlockFooter(RichTextPlain("f")) to "footer",
            InputRichBlockDivider() to "divider",
            InputRichBlockMathematicalExpression("x^2") to "mathematical_expression",
            InputRichBlockAnchor("top") to "anchor",
            InputRichBlockList(arrayOf(InputRichBlockListItem(arrayOf(InputRichBlockParagraph(RichTextPlain("i")))))) to "list",
            InputRichBlockBlockQuotation(arrayOf(InputRichBlockParagraph(RichTextPlain("q")))) to "blockquote",
            InputRichBlockPullQuotation(RichTextPlain("pq")) to "pullquote",
            InputRichBlockCollage(arrayOf(InputRichBlockPhoto(photo))) to "collage",
            InputRichBlockSlideshow(arrayOf(InputRichBlockPhoto(photo))) to "slideshow",
            InputRichBlockTable(arrayOf(emptyArray())) to "table",
            InputRichBlockDetails(RichTextPlain("s"), arrayOf(InputRichBlockParagraph(RichTextPlain("d")))) to "details",
            InputRichBlockPhoto(photo) to "photo",
            InputRichBlockThinking(RichTextPlain("t")) to "thinking",
            InputRichBlockVoiceNote(InputMediaVoiceNote("file_id")) to "voice_note"
        )

        blocks.forEach { (block, expectedType) ->
            assertEquals(expectedType, blockJson(block)["type"].asString)
        }
    }

    @Test
    fun `field names are converted to snake case`() {
        val block = blockJson(InputRichBlockVoiceNote(InputMediaVoiceNote("file_id")))

        assertEquals("voice_note", block["type"].asString)
        assertTrue(block.has("voice_note"))
    }

    @Test
    fun `rich text is serialized the same way it is parsed`() {
        val block = blockJson(
            InputRichBlockParagraph(
                RichTextArray(arrayOf(RichTextPlain("plain "), RichTextBold(RichTextPlain("bold"))))
            )
        )

        val text = block["text"].asJsonArray
        assertEquals("plain ", text[0].asString)

        val bold = text[1].asJsonObject
        assertEquals("bold", bold["type"].asString)
        assertEquals("bold", bold["text"].asString)
    }

    @Test
    fun `nested blocks keep their discriminators`() {
        val block = blockJson(
            InputRichBlockDetails(
                summary = RichTextPlain("summary"),
                blocks = arrayOf(
                    InputRichBlockList(
                        arrayOf(
                            InputRichBlockListItem(
                                blocks = arrayOf(InputRichBlockParagraph(RichTextPlain("item"))),
                                hasCheckbox = true
                            )
                        )
                    )
                )
            )
        )

        assertEquals("details", block["type"].asString)
        val list = block["blocks"].asJsonArray[0].asJsonObject
        assertEquals("list", list["type"].asString)
        val item = list["items"].asJsonArray[0].asJsonObject
        assertTrue(item["has_checkbox"].asBoolean)
        assertEquals("paragraph", item["blocks"].asJsonArray[0].asJsonObject["type"].asString)
    }

    @Test
    fun `rich message without uploads is not multipart`() {
        val request = SendRichMessage(1L, InputRichMessage().html("<b>hi</b>"))

        assertFalse(request.isMultipart)
        assertEquals("<b>hi</b>", json(request.parameters["rich_message"]!!)["html"].asString)
    }

    @Test
    fun `uploaded block media becomes a multipart part`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val request = SendRichMessage(1L, InputRichMessage().blocks(InputRichBlockPhoto(photo)))

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `uploaded media of the message becomes a multipart part`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val request = SendRichMessage(
            1L,
            InputRichMessage()
                .html("<img src=\"tg://photo?id=pic\"/>")
                .media(InputRichMessageMedia("pic", photo))
        )

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `uploads nested in other blocks are collected`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val request = SendRichMessage(
            1L,
            InputRichMessage().blocks(
                InputRichBlockDetails(
                    summary = RichTextPlain("s"),
                    blocks = arrayOf(
                        InputRichBlockCollage(
                            arrayOf(InputRichBlockPhoto(photo, RichBlockCaption(RichTextPlain("c"))))
                        )
                    )
                )
            )
        )

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `uploads added after the request was built are still collected`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val richMessage = InputRichMessage()
        val request = SendRichMessage(1L, richMessage)

        richMessage.blocks(InputRichBlockPhoto(photo))

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `uploads are collected even after the request was already inspected`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val richMessage = InputRichMessage()
        val request = SendRichMessage(1L, richMessage)

        assertFalse(request.isMultipart)
        richMessage.blocks(InputRichBlockPhoto(photo))

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `parts of a replaced block are dropped`() {
        val first = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val second = InputMediaPhoto(byteArrayOf(4, 5, 6))
        val richMessage = InputRichMessage().blocks(InputRichBlockPhoto(first))
        val request = SendRichMessage(1L, richMessage)

        assertTrue(request.parameters.containsKey(first.inputFileId))

        richMessage.blocks(InputRichBlockPhoto(second))

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(second.inputFileId))
        assertFalse(request.parameters.containsKey(first.inputFileId))
    }

    @Test
    fun `drafts collect uploads too`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val request = SendRichMessageDraft(1L, 7, InputRichMessage().blocks(InputRichBlockPhoto(photo)))

        assertEquals(1L, request.parameters["chat_id"])
        assertEquals(7, request.parameters["draft_id"])
        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `editMessageText collects uploads of its rich message`() {
        val photo = InputMediaPhoto(byteArrayOf(1, 2, 3))
        val request = EditMessageText(1L, 2, InputRichMessage().blocks(InputRichBlockPhoto(photo)))

        assertTrue(request.isMultipart)
        assertTrue(request.parameters.containsKey(photo.inputFileId))
    }

    @Test
    fun `editMessageText without a rich message stays a plain request`() {
        val request = EditMessageText(1L, 2, "text")

        assertFalse(request.isMultipart)
        assertNull(request.parameters["rich_message"])
    }
}
