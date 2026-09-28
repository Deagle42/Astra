package org.thoughtcrime.securesms.compose.settings.premium

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.PremiumFeatureModel
import org.thoughtcrime.securesms.compose.domain.models.PremiumFeatureType
import org.thoughtcrime.securesms.compose.domain.models.PremiumFeaturesModel
import org.thoughtcrime.securesms.compose.domain.models.PremiumLimitModel
import org.thoughtcrime.securesms.compose.domain.models.PremiumLimitType
import org.thoughtcrime.securesms.compose.domain.models.PremiumPaymentOptionModel
import org.thoughtcrime.securesms.compose.domain.models.PremiumSource
import org.thoughtcrime.securesms.compose.domain.repository.PremiumRepository
import org.thoughtcrime.securesms.compose.domain.repository.UserRepository
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

interface PremiumComponent {
    val state: Value<State>
    fun onBackClicked()
    fun onSubscribeClicked()
    fun onShowSponsoredMessagesChanged(enabled: Boolean)

    data class State(
        val features: List<PremiumFeature> = emptyList(),
        val limits: List<PremiumLimit> = emptyList(),
        val paymentOptions: List<PremiumPaymentOptionModel> = emptyList(),
        val paymentLink: String? = null,
        val isLoading: Boolean = false,
        val isPremium: Boolean = false,
        val statusText: String? = null,
        val showSponsoredMessagesForPremium: Boolean = false
    )

    data class PremiumFeature(
        val icon: String,
        val title: String,
        val description: String,
        val color: Long
    )

    data class PremiumLimit(
        val title: String,
        val subtitle: String? = null,
        val defaultValue: Int,
        val premiumValue: Int
    )
}
