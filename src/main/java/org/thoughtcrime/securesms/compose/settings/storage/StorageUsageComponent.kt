package org.thoughtcrime.securesms.compose.settings.storage

import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import coil3.annotation.ExperimentalCoilApi
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.ChatStorageUsageModel
import org.thoughtcrime.securesms.compose.domain.models.FileTypeStorageUsageModel
import org.thoughtcrime.securesms.compose.domain.models.StorageCleanupResultModel
import org.thoughtcrime.securesms.compose.domain.models.StorageUsageBreakdownModel
import org.thoughtcrime.securesms.compose.domain.models.StorageUsageModel
import org.thoughtcrime.securesms.compose.domain.repository.MessageDisplayer
import org.thoughtcrime.securesms.compose.domain.repository.StickerRepository
import org.thoughtcrime.securesms.compose.domain.repository.StorageRepository
import org.thoughtcrime.securesms.compose.domain.repository.StringProvider
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext
import java.util.Locale

internal const val AppTempChatId: Long = Long.MIN_VALUE
private const val AppTempFileType = "AppTemp"

interface StorageUsageComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onClearAllClicked()
    fun onClearChatClicked(chatId: Long)
    fun onCacheLimitSizeChanged(size: Long)
    fun onAutoClearCacheTimeChanged(time: Int)
    fun onStorageOptimizerChanged(enabled: Boolean)

    data class State(
        val usage: StorageUsageModel? = null,
        val breakdown: StorageUsageBreakdownModel? = null,
        val appTempUsage: AppTempCacheUsage = AppTempCacheUsage(0L, 0),
        val isLoading: Boolean = true,
        val cacheLimitSize: Long = -1L,
        val autoClearCacheTime: Int = -1,
        val isStorageOptimizerEnabled: Boolean = false
    )
}
