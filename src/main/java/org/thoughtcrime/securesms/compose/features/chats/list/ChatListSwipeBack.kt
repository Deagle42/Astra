package org.thoughtcrime.securesms.compose.features.chats.list

import org.thoughtcrime.securesms.compose.core.ui.ScreenSwipeBackAction
import org.thoughtcrime.securesms.compose.core.ui.ScreenSwipeBackPreview
import org.thoughtcrime.securesms.compose.core.ui.ScreenSwipeBackState

fun resolveArchiveReturnFolderId(
    folders: List<org.thoughtcrime.securesms.compose.domain.models.FolderModel>,
    showAllChatsFolder: Boolean,
    lastNonArchiveFolderId: Int? = null,
): Int {
    val userFolders = folders.filter { it.id >= 0 }
    val allChatsFolder = folders.firstOrNull { it.id == -1 }
    val visibleFolderIds = if (showAllChatsFolder || userFolders.isEmpty()) {
        folders.map { it.id }
    } else {
        folders.filterNot { it.id == -1 }.map { it.id }
    }
    val rememberedFolderId = lastNonArchiveFolderId?.takeIf { it in visibleFolderIds && it != -2 }

    return when {
        rememberedFolderId != null -> rememberedFolderId
        userFolders.isNotEmpty() -> userFolders.first().id
        allChatsFolder != null && allChatsFolder.id in visibleFolderIds -> allChatsFolder.id
        visibleFolderIds.isNotEmpty() -> visibleFolderIds.first()
        else -> -1
    }
}

internal fun resolveChatListSwipeBackState(
    state: ChatListComponent.State,
    showAllChatsFolder: Boolean,
    hasTransientBlockingUi: Boolean = false,
): ScreenSwipeBackState {
    val preferredFolderId = resolveArchiveReturnFolderId(
        folders = state.folders,
        showAllChatsFolder = showAllChatsFolder,
        lastNonArchiveFolderId = state.lastNonArchiveFolderId,
    )
    val hasCustomBackState =
        state.webViewUrl != null ||
                state.webAppUrl != null ||
                state.instantViewUrl != null ||
                state.isSearchActive ||
                state.forwardTopicPickerChatId != null ||
                state.isShareTargetMode ||
                state.selectedForwardTargets.isNotEmpty() ||
                state.selectedChatIds.isNotEmpty() ||
                state.isForwarding

    val supportsArchiveReturn =
        state.selectedFolderId == -2 &&
                preferredFolderId != -2 &&
                preferredFolderId != state.selectedFolderId

    return if (supportsArchiveReturn) {
        ScreenSwipeBackState(
            isSupported = true,
            isBlocked = hasTransientBlockingUi || hasCustomBackState,
            action = ScreenSwipeBackAction.LocalChatListArchiveReturn,
            preview = ScreenSwipeBackPreview.ChatListFolder,
        )
    } else {
        ScreenSwipeBackState(
            isSupported = false,
            isBlocked = hasTransientBlockingUi || hasCustomBackState,
        )
    }
}
