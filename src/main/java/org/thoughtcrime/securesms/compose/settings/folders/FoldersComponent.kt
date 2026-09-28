package org.thoughtcrime.securesms.compose.settings.folders

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.ChatModel
import org.thoughtcrime.securesms.compose.domain.models.FolderModel
import org.thoughtcrime.securesms.compose.domain.repository.ChatFolderRepository
import org.thoughtcrime.securesms.compose.domain.repository.ChatListRepository
import org.thoughtcrime.securesms.compose.domain.repository.ChatSearchRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface FoldersComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onCreateFolderClicked()
    fun onFolderClicked(folderId: Int)
    fun onDeleteFolder(folderId: Int)
    fun onEditFolder(folderId: Int, newTitle: String, iconName: String?, includedChatIds: List<Long>)
    fun onAddFolder(title: String, iconName: String?, includedChatIds: List<Long>)
    fun onMoveFolder(fromIndex: Int, toIndex: Int)
    fun onSearchChats(query: String)

    data class State(
        val folders: List<FolderModel> = emptyList(),
        val isLoading: Boolean = false,
        val showAddFolderDialog: Boolean = false,
        val showEditFolderDialog: Boolean = false,
        val selectedFolder: FolderModel? = null,
        val availableChats: List<ChatModel> = emptyList(),
        val selectedChatIds: List<Long> = emptyList()
    )
}
