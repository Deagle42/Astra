package org.thoughtcrime.securesms.compose.settings.proxy

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.core.telegram.TelegramLinkDomains
import org.json.JSONArray
import org.json.JSONObject
import org.thoughtcrime.securesms.compose.domain.models.ProxyCheckResult
import org.thoughtcrime.securesms.compose.domain.models.ProxyInput
import org.thoughtcrime.securesms.compose.domain.models.ProxyModel
import org.thoughtcrime.securesms.compose.domain.models.ProxyTypeModel
import org.thoughtcrime.securesms.compose.domain.models.toDomainProxyType
import org.thoughtcrime.securesms.compose.domain.models.toProxyModel
import org.thoughtcrime.securesms.compose.domain.repository.AppPreferencesProvider
import org.thoughtcrime.securesms.compose.domain.repository.DEFAULT_SMART_SWITCH_CHECK_INTERVAL_MINUTES
import org.thoughtcrime.securesms.compose.domain.repository.LinkAction
import org.thoughtcrime.securesms.compose.domain.repository.LinkHandlerRepository
import org.thoughtcrime.securesms.compose.domain.repository.ProxyDiagnosticsRepository
import org.thoughtcrime.securesms.compose.domain.repository.ProxyNetworkMode
import org.thoughtcrime.securesms.compose.domain.repository.ProxyNetworkRule
import org.thoughtcrime.securesms.compose.domain.repository.ProxyNetworkType
import org.thoughtcrime.securesms.compose.domain.repository.ProxyRepository
import org.thoughtcrime.securesms.compose.domain.repository.ProxySmartSwitchMode
import org.thoughtcrime.securesms.compose.domain.repository.ProxySortMode
import org.thoughtcrime.securesms.compose.domain.repository.ProxyUnavailableFallback
import org.thoughtcrime.securesms.compose.domain.repository.StringProvider
import org.thoughtcrime.securesms.compose.domain.repository.defaultProxyNetworkMode
import org.thoughtcrime.securesms.compose.core.util.coRunCatching
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface ProxyComponent {
    val state: Value<State>

    fun onBackClicked()
    fun onAddProxyClicked()
    fun onEditProxyClicked(proxy: ProxyModel)
    fun onProxyClicked(proxy: ProxyModel)
    fun onProxyLongClicked(proxy: ProxyModel)
    fun onEnableProxy(proxyId: Int)
    fun onDisableProxy()
    fun onRemoveProxy(proxyId: Int)
    fun onPingAll()
    fun onPingProxy(proxyId: Int)
    fun onPingDatacenters()
    fun onAddProxy(server: String, port: Int, comment: String?, type: ProxyTypeModel)
    fun onEditProxy(proxyId: Int, server: String, port: Int, comment: String?, type: ProxyTypeModel)
    fun onDismissDeleteConfirmation()
    fun onConfirmDelete()
    fun onDismissAddEdit()
    fun onAutoBestProxyToggled(enabled: Boolean)
    fun onSmartSwitchModeChanged(mode: ProxySmartSwitchMode)
    fun onSmartSwitchAutoCheckIntervalChanged(minutes: Int)
    fun onPreferIpv6Toggled(enabled: Boolean)
    fun onProxySortModeChanged(mode: ProxySortMode)
    fun onProxyUnavailableFallbackChanged(fallback: ProxyUnavailableFallback)
    fun onHideOfflineProxiesToggled(enabled: Boolean)
    fun onToggleFavoriteProxy(proxyId: Int)
    fun exportProxiesJson(): String
    fun importProxiesJson(json: String)
    fun importProxiesFromText(rawText: String)
    fun onProxyNetworkModeChanged(networkType: ProxyNetworkType, mode: ProxyNetworkMode)
    fun onSpecificProxyForNetworkSelected(networkType: ProxyNetworkType, proxyId: Int)
    fun onClearUnavailableProxies()
    fun onRemoveAllProxies()
    fun onConfirmClearUnavailableProxies()
    fun onConfirmRemoveAllProxies()
    fun onDismissToast()
    fun onDismissMassDeleteDialogs()
    fun onDnsProviderChanged(provider: String)
    fun onCustomDnsUrlChanged(url: String)
    fun onCustomDnsHeadersChanged(headers: String)

    data class State(
        val proxies: List<ProxyModel> = emptyList(),
        val visibleProxies: List<ProxyModel> = emptyList(),
        val isLoading: Boolean = false,
        val isAddingProxy: Boolean = false,
        val isAutoBestProxyEnabled: Boolean = false,
        val smartSwitchMode: ProxySmartSwitchMode = ProxySmartSwitchMode.RANDOM_AVAILABLE,
        val smartSwitchAutoCheckIntervalMinutes: Int = DEFAULT_SMART_SWITCH_CHECK_INTERVAL_MINUTES,
        val preferIpv6: Boolean = false,
        val proxySortMode: ProxySortMode = ProxySortMode.LOWEST_PING,
        val proxyUnavailableFallback: ProxyUnavailableFallback = ProxyUnavailableFallback.BEST_PROXY,
        val hideOfflineProxies: Boolean = false,
        val favoriteProxyId: Int? = null,
        val proxyNetworkRules: Map<ProxyNetworkType, ProxyNetworkRule> = ProxyNetworkType.entries.associateWith {
            ProxyNetworkRule(defaultProxyNetworkMode(it))
        },
        val proxyToEdit: ProxyModel? = null,
        val proxyToDelete: ProxyModel? = null,
        val isDcTesting: Boolean = false,
        val dcPingByDcId: Map<Int, Long?> = emptyMap(),
        val dcPingErrorsByDcId: Map<Int, String> = emptyMap(),
        val proxyErrors: Map<Int, String> = emptyMap(),
        val toastMessage: String? = null,
        val showClearOfflineConfirmation: Boolean = false,
        val showRemoveAllConfirmation: Boolean = false,
        val checkingProxyIds: Set<Int> = emptySet(),
        val dnsProvider: String = "google",
        val customDnsUrl: String = "",
        val customDnsHeaders: String = ""
    )
}
