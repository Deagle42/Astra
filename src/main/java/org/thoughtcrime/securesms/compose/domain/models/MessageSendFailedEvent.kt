package org.thoughtcrime.securesms.compose.domain.models

data class MessageSendFailedEvent(
    val chatId: Long,
    val temporaryMessageId: Long,
    val message: MessageModel,
    val errorCode: Int
)
