package org.thoughtcrime.securesms.compose.domain.repository

interface RichTextParsingRepository {
    suspend fun parseTextEntities(
        text: String,
        mode: RichTextParseMode
    ): FormattedTextResult
}

enum class RichTextParseMode {
    Markdown,
    Html
}
