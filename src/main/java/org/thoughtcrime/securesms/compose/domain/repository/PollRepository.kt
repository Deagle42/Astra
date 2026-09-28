package org.thoughtcrime.securesms.compose.domain.repository

interface PollRepository {
    suspend fun mapPollIdToMessage(pollId: Long, chatId: Long, messageId: Long)
    suspend fun getMessageIdByPollId(pollId: Long): Pair<Long, Long>? // chatId, messageId
}