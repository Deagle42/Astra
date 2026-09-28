package org.thoughtcrime.securesms.compose.settings.privacy

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.ChatModel
import org.thoughtcrime.securesms.compose.domain.models.PrivacyValue
import org.thoughtcrime.securesms.compose.domain.models.UserModel
import org.thoughtcrime.securesms.compose.domain.repository.ChatListRepository
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyKey
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyRepository
import org.thoughtcrime.securesms.compose.domain.repository.UserRepository
import org.thoughtcrime.securesms.compose.R
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface PrivacySettingComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onPrivacyValueChanged(value: PrivacyValue)
    fun onSearchPrivacyValueChanged(value: PrivacyValue)
    fun onAddExceptionClicked(isAllow: Boolean)
    fun onUserClicked(userId: Long)
    fun onRemoveUser(userId: Long, isAllow: Boolean)
    fun onRemoveChat(chatId: Long, isAllow: Boolean)

    data class State(
        val titleRes: Int,
        val privacyKey: PrivacyKey,
        val selectedValue: PrivacyValue = PrivacyValue.EVERYBODY,
        val searchSelectedValue: PrivacyValue = PrivacyValue.EVERYBODY,
        val allowUsers: List<UserModel> = emptyList(),
        val disallowUsers: List<UserModel> = emptyList(),
        val allowChats: List<ChatModel> = emptyList(),
        val disallowChats: List<ChatModel> = emptyList(),
        val isLoading: Boolean = false
    )
}
