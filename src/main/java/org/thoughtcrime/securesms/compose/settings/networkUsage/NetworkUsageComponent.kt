package org.thoughtcrime.securesms.compose.settings.networkUsage

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.NetworkUsageModel
import org.thoughtcrime.securesms.compose.domain.repository.NetworkStatisticsRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface NetworkUsageComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onResetClicked()
    fun onToggleNetworkStats(enabled: Boolean)

    data class State(
        val usage: NetworkUsageModel? = null,
        val isLoading: Boolean = true,
        val isNetworkStatsEnabled: Boolean = true
    )
}
