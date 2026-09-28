package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.ChatEventLogFiltersModel
import org.thoughtcrime.securesms.compose.domain.models.ChatEventModel

interface ChatEventLogRepository {
    suspend fun getChatEventLog(
        chatId: Long,
        query: String = "",
        fromEventId: Long = 0,
        limit: Int = 50,
        filters: ChatEventLogFiltersModel = ChatEventLogFiltersModel(),
        userIds: List<Long> = emptyList()
    ): List<ChatEventModel>
}