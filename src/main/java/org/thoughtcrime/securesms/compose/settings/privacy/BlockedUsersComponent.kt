package org.thoughtcrime.securesms.compose.settings.privacy

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.UserModel
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyRepository
import org.thoughtcrime.securesms.compose.domain.repository.UserRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface BlockedUsersComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onUnblockUserClicked(userId: Long)
    fun onAddBlockedUserClicked()
    fun onUserClicked(userId: Long)

    data class State(
        val isLoading: Boolean = false,
        val blockedUsers: List<UserModel> = emptyList()
    )
}
