package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.SessionModel

interface SessionRepository {
    suspend fun getActiveSessions(): List<SessionModel>
    suspend fun terminateSession(sessionId: Long): Boolean
    suspend fun confirmQrCode(link: String): Boolean
}