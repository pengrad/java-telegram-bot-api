# Design: full rich message sending support

Date: 2026-08-06
Bot API version: 10.1

## Problem

The library already ships `SendRichMessage`, `SendRichMessageDraft` and `InputRichMessage`,
but `InputRichMessage` only exposes `html`, `markdown`, `is_rtl` and `skip_entity_detection`.
The Bot API also allows a rich message to be described as a list of blocks (`blocks`) and to
carry embedded media (`media`). Neither is representable today, and two lower-level problems
would break any attempt to add them:

1. **The `type` discriminator is never serialized.** `RichBlock` and `RichText` implementations
   declare `override val type: String get() = "..."` — a computed property with no backing
   field. Gson serializes fields, so every block sent to Telegram would omit `type`. The
   adapters registered in `BotUtils` are `JsonDeserializer` only.
2. **No multipart plumbing.** `SendRichMessage` extends `AbstractSendRequest`, which inherits
   `isMultipart() == false`. A block holding a freshly uploaded file would serialize an
   `attach://` reference with no corresponding multipart part.

`InputMediaVoiceNote` is also missing from the library, and `InputRichBlockVoiceNote` requires it.

## Scope

Full support for sending rich messages: `blocks`, `media`, file uploads, `sendRichMessage`
and `sendRichMessageDraft`. `editMessageText` is included because it already accepts an
`InputRichMessage` and shares the multipart defect.

## Design

### 1. Input block models

New package `model.request.richmessages.inputrichblock`:

- `InputRichBlock` — interface exposing `val type: String`, mirroring `RichBlock`.
- 21 concrete blocks: `Paragraph`, `SectionHeading`, `Preformatted`, `Footer`, `Divider`,
  `MathematicalExpression`, `Anchor`, `List`, `BlockQuotation`, `PullQuotation`, `Collage`,
  `Slideshow`, `Table`, `Details`, `Map`, `Animation`, `Audio`, `Photo`, `Video`,
  `VoiceNote`, `Thinking`.
- `InputRichBlockListItem` — note it has no `label` (unlike the received `RichBlockListItem`)
  and carries the ordered-list label `type`.

The `type` string constants are identical to the receive side, so `RichBlockType` is reused
rather than duplicated. Blocks reference the existing received types where the API specifies
them: `RichText`, `RichBlockCaption`, `RichBlockTableCell`, `Location`.

New `model.request.richmessages.InputRichMessageMedia` (`id` + `InputMedia`) and
`model.request.InputMediaVoiceNote` (Java, matching its `InputMedia` siblings).

### 2. Serialization

`RichTextTypeAdapter` and `RichBlockTypeAdapter` additionally implement `JsonSerializer`;
a new `InputRichBlockSerializer` covers the input hierarchy. Each delegates to the concrete
runtime type and injects the discriminator:

```kotlin
val obj = context.serialize(src, src.javaClass).asJsonObject
obj.addProperty("type", src.type)
```

This does not recurse: the adapter is registered against the interface, while
`src.javaClass` resolves to the concrete class's reflective adapter.

`RichText` needs two special cases, matching how it is parsed: `RichTextPlain` serializes as
a bare JSON string and `RichTextArray` as a JSON array.

All three are registered in `BotUtils.GSON`.

### 3. Attachment collection

`utility.richmessages.RichMessageAttachments.collect(InputRichMessage)` walks `media` and
`blocks` — descending into `list`, `blockquote`, `collage`, `slideshow` and `details` — and
returns the `attach://` name to file mapping gathered from each `InputMedia`.

`SendRichMessage`, `SendRichMessageDraft` and `EditMessageText` call it lazily and
idempotently from their `isMultipart()` and `getParameters()` overrides. Both are read by
`TelegramBotClient` at send time, so a message mutated after the request was constructed is
still captured — unlike `SendMediaGroup`, which collects in its constructor.

### 4. `InputRichMessage`

Gains `blocks: Array<InputRichBlock>?` and `media: Array<InputRichMessageMedia>?` with fluent
setters, keeping the existing `equals`/`hashCode`/`toString` style.

### 5. Kotlin DSL

`SendRichMessageExtension.kt` and `SendRichMessageDraftExtension.kt` in
`utility.kotlin.extension.request`, following `SendMessageExtension.kt`.

### 6. Testing

Unit tests (no network):

- every input block serializes with the right `type` and snake_case keys;
- `RichTextPlain` serializes as a string, `RichTextArray` as an array;
- nested blocks serialize recursively;
- attachment collection sets `isMultipart` and emits the `attach://` parts, including for
  nested blocks;
- mutating the `InputRichMessage` *after* constructing the request is still picked up.

Integration coverage in `TelegramBotTest` (requires `TEST_TOKEN`/`CHAT_ID`): send a rich
message with a text block plus an uploaded photo, and a draft carrying a `thinking` block.

## Out of scope

Receiving rich messages (already supported) and inline query results carrying
`InputRichMessageContent` beyond what already exists — inline results cannot upload files.
