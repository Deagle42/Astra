package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.MessageEntity

data class FormattedTextResult(
    val text: String,
    val entities: List<MessageEntity>
)

data class FixedTextResult(
    val text: String,
    val entities: List<MessageEntity>
)

data class TextCompositionStyleModel(
    val name: String,
    val customEmojiId: Long,
    val title: String
)
