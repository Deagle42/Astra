package org.thoughtcrime.securesms.compose.settings.sessions

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.SessionModel
import org.thoughtcrime.securesms.compose.domain.repository.SessionRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface SessionsComponent {
    val state: Value<State>
    fun onBackClicked()
    fun terminateSession(id: Long)
    fun onQrCodeScanned(link: String)
    fun confirmAuth()
    fun dismissAuth()
    fun toggleScanner(show: Boolean)
    fun refresh()

    data class State(
        val sessions: List<SessionModel> = emptyList(),
        val isLoading: Boolean = false,
        val isScanning: Boolean = false,
        val pendingLink: String? = null,
        val showConfirmation: Boolean = false
    )
}
