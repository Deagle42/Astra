package org.thoughtcrime.securesms.compose.domain.models

data class MessageViewerModel(
    val user: UserModel,
    val viewedDate: Int
)