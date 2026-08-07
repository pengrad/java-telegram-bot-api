package com.pengrad.telegrambot.utility.richmessages

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.model.request.richmessages.inputrichblock.*

/**
 * Collects the files that a rich message uploads, keyed by the `attach://` name referenced in
 * the serialized payload. A request is multipart exactly when the result is not empty.
 */
object RichMessageAttachments {

    @JvmStatic
    fun collect(richMessage: InputRichMessage?): Map<String, Any> {
        if (richMessage == null) return emptyMap()
        val attachments = LinkedHashMap<String, Any>()
        richMessage.media?.forEach { collectMedia(it.media, attachments) }
        richMessage.blocks?.forEach { collectBlock(it, attachments) }
        return attachments
    }

    private fun collectMedia(media: InputMedia<*>, attachments: MutableMap<String, Any>) {
        media.attachments?.let { attachments.putAll(it) }
        val inputFile = media.inputFile()
        val inputFileId = media.inputFileId
        if (inputFile != null && inputFileId != null) {
            attachments[inputFileId] = inputFile
        }
    }

    private fun collectBlocks(blocks: Array<InputRichBlock>, attachments: MutableMap<String, Any>) {
        blocks.forEach { collectBlock(it, attachments) }
    }

    private fun collectBlock(block: InputRichBlock, attachments: MutableMap<String, Any>) {
        when (block) {
            is InputRichBlockPhoto -> collectMedia(block.photo, attachments)
            is InputRichBlockVideo -> collectMedia(block.video, attachments)
            is InputRichBlockAudio -> collectMedia(block.audio, attachments)
            is InputRichBlockAnimation -> collectMedia(block.animation, attachments)
            is InputRichBlockVoiceNote -> collectMedia(block.voiceNote, attachments)
            is InputRichBlockCollage -> collectBlocks(block.blocks, attachments)
            is InputRichBlockSlideshow -> collectBlocks(block.blocks, attachments)
            is InputRichBlockDetails -> collectBlocks(block.blocks, attachments)
            is InputRichBlockBlockQuotation -> collectBlocks(block.blocks, attachments)
            is InputRichBlockList -> block.items.forEach { collectBlocks(it.blocks, attachments) }
            else -> Unit
        }
    }
}
