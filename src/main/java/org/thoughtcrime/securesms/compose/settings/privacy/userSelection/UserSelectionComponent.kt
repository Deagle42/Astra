package org.thoughtcrime.securesms.compose.settings.privacy.userSelection

import com.arkivanov.decompose.value.Value
import org.thoughtcrime.securesms.compose.domain.models.UserModel

interface UserSelectionComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onSearchQueryChanged(query: String)
    fun onUserClicked(userId: Long)

    data class State(
        val searchQuery: String = "",
        val users: List<UserModel> = emptyList(),
        val isLoading: Boolean = false
    )
}
