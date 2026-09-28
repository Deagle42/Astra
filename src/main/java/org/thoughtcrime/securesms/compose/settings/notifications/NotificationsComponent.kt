package org.thoughtcrime.securesms.compose.settings.notifications

import android.os.Parcelable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import org.thoughtcrime.securesms.compose.domain.managers.DistrManager
import org.thoughtcrime.securesms.compose.domain.models.ChatModel
import org.thoughtcrime.securesms.compose.domain.repository.ClientOptionsRepository
import org.thoughtcrime.securesms.compose.domain.repository.NotificationSettingsRepository
import org.thoughtcrime.securesms.compose.domain.repository.NotificationSettingsRepository.TdNotificationScope
import org.thoughtcrime.securesms.compose.domain.repository.PushProvider
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface NotificationsComponent {
    val state: Value<State>
    val childStack: Value<ChildStack<*, Child>>

    fun onBackClicked()
    fun onPrivateChatsToggled(enabled: Boolean)
    fun onGroupsToggled(enabled: Boolean)
    fun onChannelsToggled(enabled: Boolean)
    fun onInAppSoundsToggled(enabled: Boolean)
    fun onInAppVibrateToggled(enabled: Boolean)
    fun onInAppPreviewToggled(enabled: Boolean)
    fun onContactJoinedToggled(enabled: Boolean)
    fun onScheduledMessagesToggled(enabled: Boolean)
    fun onPinnedMessagesToggled(enabled: Boolean)
    fun onBackgroundServiceToggled(enabled: Boolean)
    fun onHideForegroundNotificationToggled(enabled: Boolean)
    fun onVibrationPatternChanged(pattern: String)
    fun onPriorityChanged(priority: Int)
    fun onRepeatNotificationsChanged(minutes: Int)
    fun onShowSenderOnlyToggled(enabled: Boolean)
    fun onPushProviderChanged(provider: PushProvider)
    fun onResetNotificationsClicked()
    fun onExceptionClicked(scope: TdNotificationScope)
    fun onChatExceptionToggled(chatId: Long, enabled: Boolean)
    fun onChatExceptionReset(chatId: Long)

    data class State(
        val privateChatsEnabled: Boolean = true,
        val groupsEnabled: Boolean = true,
        val channelsEnabled: Boolean = true,
        val inAppSounds: Boolean = true,
        val inAppVibrate: Boolean = true,
        val inAppPreview: Boolean = true,
        val contactJoined: Boolean = true,
        val scheduledMessages: Boolean = true,
        val pinnedMessages: Boolean = true,
        val backgroundServiceEnabled: Boolean = false,
        val hideForegroundNotification: Boolean = false,
        val vibrationPattern: String = "default",
        val priority: Int = 1,
        val repeatNotifications: Int = 0,
        val showSenderOnly: Boolean = false,
        val pushProvider: PushProvider = PushProvider.FCM,
        val isGmsAvailable: Boolean = false,
        val isUnifiedPushAvailable: Boolean = false,
        val privateExceptions: List<ChatModel>? = null,
        val groupExceptions: List<ChatModel>? = null,
        val channelExceptions: List<ChatModel>? = null
    )

    sealed class Child {
        object Main : Child()
        class Exceptions(val scope: TdNotificationScope) : Child()
    }
}
