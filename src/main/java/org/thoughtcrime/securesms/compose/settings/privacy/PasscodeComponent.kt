package org.thoughtcrime.securesms.compose.settings.privacy

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import org.thoughtcrime.securesms.compose.domain.repository.AppPreferencesProvider
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface PasscodeComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onPasscodeEntered(passcode: String)
    fun onClearPasscode()

    data class State(
        val isPasscodeSet: Boolean = false,
        val error: String? = null
    )
}
