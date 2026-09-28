package org.thoughtcrime.securesms.compose.domain.models

import org.thoughtcrime.securesms.compose.domain.repository.ChatMemberStatus

data class GroupMemberModel(
    val user: UserModel,
    val rank: String? = null,
    val status: ChatMemberStatus? = null
)