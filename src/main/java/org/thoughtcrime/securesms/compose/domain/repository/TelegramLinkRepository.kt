package org.thoughtcrime.securesms.compose.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface TelegramLinkRepository {
    val baseUrl: StateFlow<String>

    suspend fun buildUrl(path: String): String
}
