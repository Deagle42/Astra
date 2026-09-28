package org.thoughtcrime.securesms.compose.settings.stickers

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.StickerSetModel
import org.thoughtcrime.securesms.compose.domain.repository.EmojiRepository
import org.thoughtcrime.securesms.compose.domain.repository.StickerRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface StickersComponent {
    val state: Value<State>

    fun onBackClicked()
    fun onStickerSetClicked(stickerSet: StickerSetModel)
    fun onToggleStickerSet(stickerSet: StickerSetModel)
    fun onArchiveStickerSet(stickerSet: StickerSetModel)
    fun onClearRecentStickers()
    fun onClearRecentEmojis()
    fun onTabSelected(index: Int)
    fun onSearchQueryChanged(query: String)
    fun onMoveStickerSet(fromIndex: Int, toIndex: Int)
    fun onAddStickersClicked()
    fun onDismissMiniApp()

    data class State(
        val stickerSets: List<StickerSetModel> = emptyList(),
        val emojiSets: List<StickerSetModel> = emptyList(),
        val archivedStickerSets: List<StickerSetModel> = emptyList(),
        val archivedEmojiSets: List<StickerSetModel> = emptyList(),
        val isLoading: Boolean = true,
        val selectedTabIndex: Int = 0,
        val searchQuery: String = "",
        val miniAppUrl: String? = null,
        val miniAppName: String? = null,
        val miniAppBotUserId: Long = 0L
    )
}
