package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.PremiumFeaturesModel
import org.thoughtcrime.securesms.compose.domain.models.PremiumSource
import org.thoughtcrime.securesms.compose.domain.models.PremiumStateModel

interface PremiumRepository {
    suspend fun getPremiumState(): PremiumStateModel?
    suspend fun getPremiumFeatures(source: PremiumSource): PremiumFeaturesModel?
    suspend fun setSponsoredMessagesEnabled(enabled: Boolean)
}
