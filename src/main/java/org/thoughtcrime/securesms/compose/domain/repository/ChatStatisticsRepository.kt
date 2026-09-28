package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.ChatRevenueStatisticsModel
import org.thoughtcrime.securesms.compose.domain.models.ChatStatisticsModel
import org.thoughtcrime.securesms.compose.domain.models.StatisticsGraphModel

interface ChatStatisticsRepository {
    suspend fun getChatStatistics(chatId: Long, isDark: Boolean): ChatStatisticsModel?
    suspend fun getChatRevenueStatistics(chatId: Long, isDark: Boolean): ChatRevenueStatisticsModel?
    suspend fun loadStatisticsGraph(chatId: Long, token: String, x: Long): StatisticsGraphModel?
}