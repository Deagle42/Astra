package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.StorageCleanupResultModel
import org.thoughtcrime.securesms.compose.domain.models.StorageUsageBreakdownModel
import org.thoughtcrime.securesms.compose.domain.models.StorageUsageModel

interface StorageRepository {
    suspend fun getStorageUsage(): StorageUsageModel?
    suspend fun getStorageUsageBreakdown(): StorageUsageBreakdownModel?
    suspend fun clearStorage(chatId: Long? = null): StorageCleanupResultModel
    suspend fun setDatabaseMaintenanceSettings(maxDatabaseSize: Long, maxTimeFromLastAccess: Int): Boolean

    suspend fun getStorageOptimizerEnabled(): Boolean
    suspend fun setStorageOptimizerEnabled(enabled: Boolean)
}