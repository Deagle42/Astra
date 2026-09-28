package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.NetworkUsageModel

interface NetworkStatisticsRepository {
    suspend fun getNetworkUsage(): NetworkUsageModel?
    suspend fun getNetworkStatisticsEnabled(): Boolean
    suspend fun setNetworkStatisticsEnabled(enabled: Boolean)
    suspend fun resetNetworkStatistics(): Boolean
}