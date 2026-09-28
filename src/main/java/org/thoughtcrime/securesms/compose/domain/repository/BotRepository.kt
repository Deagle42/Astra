package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.BotCommandModel
import org.thoughtcrime.securesms.compose.domain.models.BotInfoModel

interface BotRepository {
    suspend fun getBotCommands(botId: Long): List<BotCommandModel>
    suspend fun getBotInfo(botId: Long): BotInfoModel?
}