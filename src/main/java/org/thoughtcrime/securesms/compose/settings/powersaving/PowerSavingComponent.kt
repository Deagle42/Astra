package org.thoughtcrime.securesms.compose.settings.powersaving

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.repository.AppPreferencesProvider
import org.thoughtcrime.securesms.compose.domain.repository.ClientOptionsRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface PowerSavingComponent {
    val state: Value<State>

    fun onBackClicked()
    fun onChatAnimationsToggled(enabled: Boolean)
    fun onAnimatedEmojiToggled(enabled: Boolean)
    fun onBackgroundServiceToggled(enabled: Boolean)
    fun onPowerSavingModeToggled(enabled: Boolean)
    fun onWakeLockToggled(enabled: Boolean)
    fun onBatteryOptimizationToggled(enabled: Boolean)

    data class State(
        val isChatAnimationsEnabled: Boolean = true,
        val isAnimatedEmojiEnabled: Boolean = true,
        val backgroundServiceEnabled: Boolean = false,
        val isPowerSavingModeEnabled: Boolean = false,
        val isWakeLockEnabled: Boolean = false,
        val batteryOptimizationEnabled: Boolean = false
    )
}
