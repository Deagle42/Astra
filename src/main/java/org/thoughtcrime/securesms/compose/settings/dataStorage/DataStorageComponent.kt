package org.thoughtcrime.securesms.compose.settings.dataStorage

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.thoughtcrime.securesms.compose.domain.repository.ChatCreationRepository
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface DataStorageComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onAutoDownloadMobileChanged(enabled: Boolean)
    fun onAutoDownloadWifiChanged(enabled: Boolean)
    fun onAutoDownloadRoamingChanged(enabled: Boolean)
    fun onAutoDownloadFilesChanged(enabled: Boolean)
    fun onAutoDownloadStickersChanged(enabled: Boolean)
    fun onAutoDownloadVideoNotesChanged(enabled: Boolean)
    fun onAutoplayGifsChanged(enabled: Boolean)
    fun onAutoplayVideosChanged(enabled: Boolean)
    fun onEnableStreamingChanged(enabled: Boolean)
    fun onStorageUsageClicked()
    fun onNetworkUsageClicked()
    fun onClearDatabaseClicked()

    data class State(
        val autoDownloadMobile: Boolean = true,
        val autoDownloadWifi: Boolean = true,
        val autoDownloadRoaming: Boolean = false,
        val autoDownloadFiles: Boolean = false,
        val autoDownloadStickers: Boolean = true,
        val autoDownloadVideoNotes: Boolean = true,
        val autoplayGifs: Boolean = true,
        val autoplayVideos: Boolean = true,
        val enableStreaming: Boolean = true,
        val databaseSize: String = "0 B"
    )
}
