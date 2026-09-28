package org.thoughtcrime.securesms.compose.settings.settings

import com.arkivanov.decompose.value.Value
import org.thoughtcrime.securesms.compose.domain.models.UserModel
import org.thoughtcrime.securesms.compose.core.util.IDownloadUtils
import org.thoughtcrime.securesms.compose.domain.repository.FileRepository
import org.thoughtcrime.securesms.compose.features.viewers.FullscreenImageItem

interface SettingsComponent {
    val state: Value<State>
    val downloadUtils: IDownloadUtils
    val fileRepository: FileRepository

    fun onBackClicked()
    fun onEditProfileClicked()
    fun onLogoutClicked()
    fun onNotificationToggled(enabled: Boolean)
    fun onDevicesClicked()
    fun onFoldersClicked()
    fun onChatSettingsClicked()
    fun onDataStorageClicked()
    fun onPowerSavingClicked()
    fun onPremiumClicked()
    fun onPrivacyClicked()
    fun onNotificationsClicked()
    fun onLinkSettingsClicked()
    fun checkLinkStatus()
    fun onQrCodeClicked()
    fun onQrCodeDismissed()
    fun onProxySettingsClicked()
    fun onStickersClicked()
    fun onAboutClicked()
    fun onDebugClicked()
    fun onBoostyClicked()
    fun onCryptoDonateClicked()
    fun onGithubClicked()
    fun onMoreOptionsClicked()
    fun onMoreOptionsDismissed()
    fun onSetEmojiStatus(customEmojiId: Long, statusPath: String?)
    fun onAvatarClick()
    fun onDismissAvatarViewer()

    data class State(
        val currentUser: UserModel? = null,
        val areNotificationsEnabled: Boolean = true,
        val isTMeLinkEnabled: Boolean = true,
        val isQrVisible: Boolean = false,
        val qrContent: String = "",
        val isCurrentUserSponsor: Boolean = false,
        val supportersCount: Int = 0,
        val isSupportersLoading: Boolean = true,
        val isProjectChannelSubscribed: Boolean = false,
        val isMoreOptionsVisible: Boolean = false,
        val fullScreenImages: List<FullscreenImageItem>? = null,
        val fullScreenVideoPath: String? = null
    )
}
