package org.thoughtcrime.securesms.compose.settings.adblock

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.thoughtcrime.securesms.compose.domain.managers.AssetsManager
import org.thoughtcrime.securesms.compose.domain.managers.ClipManager
import org.thoughtcrime.securesms.compose.domain.models.ChatModel
import org.thoughtcrime.securesms.compose.domain.repository.ChatListRepository
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface AdBlockComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onAdBlockEnabledChanged(enabled: Boolean)
    fun onAddKeywords(keywords: String)
    fun onRemoveKeyword(keyword: String)
    fun onClearKeywords()
    fun onCopyKeywords()
    fun onRemoveWhitelistedChannel(channelId: Long)
    fun onClearWhitelistedChannels()
    fun onLoadFromAssets()
    fun onWhitelistedChannelsClicked()
    fun onAddKeywordClicked()
    fun onDismissBottomSheet()

    data class State(
        val isEnabled: Boolean = false,
        val keywords: Set<String> = emptySet(),
        val whitelistedChannels: Set<Long> = emptySet(),
        val isLoading: Boolean = false,
        val showWhitelistedSheet: Boolean = false,
        val showAddKeywordSheet: Boolean = false,
        val whitelistedChannelModels: List<ChatModel> = emptyList()
    )
}
