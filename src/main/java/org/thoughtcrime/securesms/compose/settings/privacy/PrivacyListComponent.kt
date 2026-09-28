package org.thoughtcrime.securesms.compose.settings.privacy

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.managers.DistrManager
import org.thoughtcrime.securesms.compose.domain.models.PrivacyRule
import org.thoughtcrime.securesms.compose.domain.models.PrivacyValue
import org.thoughtcrime.securesms.compose.domain.repository.AppPreferencesProvider
import org.thoughtcrime.securesms.compose.domain.repository.ClientOptionsRepository
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyKey
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface PrivacyListComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onBlockedUsersClicked()
    fun onPhoneNumberClicked()
    fun onLastSeenClicked()
    fun onProfilePhotoClicked()
    fun onBioClicked()
    fun onForwardedMessagesClicked()
    fun onCallsClicked()
    fun onGroupsAndChannelsClicked()
    fun onTwoStepVerificationClicked()
    fun onActiveSessionsClicked()
    fun onDeleteAccountClicked(reason: String)
    fun onAccountTtlChanged(days: Int)
    fun onSensitiveContentChanged(enabled: Boolean)
    fun onArchiveAndMuteUnknownChatsChanged(enabled: Boolean)
    fun onPasscodeClicked()
    fun onPasscodeVerificationSubmitted(passcode: String)
    fun onPasscodeVerificationDismissed()
    fun onBiometricChanged(enabled: Boolean)

    data class State(
        val isLoading: Boolean = false,
        val phoneNumberPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val lastSeenPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val profilePhotoPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val bioPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val forwardedMessagesPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val callsPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val groupsAndChannelsPrivacy: PrivacyValue = PrivacyValue.EVERYBODY,
        val blockedUsersCount: Int = 0,
        val accountTtlDays: Int = 180,
        val isTwoStepVerificationEnabled: Boolean = false,
        val canShowSensitiveContent: Boolean = false,
        val isSensitiveContentEnabled: Boolean = false,
        val canArchiveAndMuteUnknownChats: Boolean = false,
        val isArchiveAndMuteUnknownChatsEnabled: Boolean = false,
        val isPasscodeEnabled: Boolean = false,
        val isPasscodeVerificationVisible: Boolean = false,
        val isPasscodeVerificationInvalid: Boolean = false,
        val isBiometricEnabled: Boolean = false,
        val error: String? = null,
        val isInstalledFromGooglePlay: Boolean = true
    )
}
