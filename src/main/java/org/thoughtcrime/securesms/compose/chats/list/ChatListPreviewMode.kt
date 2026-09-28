package org.thoughtcrime.securesms.compose.chats.list

sealed interface ChatListPreviewMode {
    data object Active : ChatListPreviewMode

    data class FolderPreview(
        val folderId: Int,
    ) : ChatListPreviewMode
}
