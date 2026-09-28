package org.thoughtcrime.securesms.compose.domain.repository

import kotlinx.coroutines.flow.Flow
import org.thoughtcrime.securesms.compose.domain.models.AttachMenuBotModel

interface AttachMenuBotRepository {
    fun getAttachMenuBots(): Flow<List<AttachMenuBotModel>>
}