package org.thoughtcrime.securesms.compose.domain.repository

import kotlinx.coroutines.flow.StateFlow
import org.thoughtcrime.securesms.compose.domain.models.TdLibLimits

interface TdLibLimitsRepository {
    val limits: StateFlow<TdLibLimits>

    suspend fun refresh()
}
