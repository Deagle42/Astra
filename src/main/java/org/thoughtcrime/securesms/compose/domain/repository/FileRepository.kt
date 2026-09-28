package org.thoughtcrime.securesms.compose.domain.repository

import kotlinx.coroutines.flow.Flow
import org.thoughtcrime.securesms.compose.domain.models.FileDownloadEvent
import org.thoughtcrime.securesms.compose.domain.models.FileModel
import org.thoughtcrime.securesms.compose.domain.models.MessageDownloadEvent

interface FileRepository {
    val fileDownloadFlow: Flow<FileDownloadEvent>
    val messageDownloadFlow: Flow<MessageDownloadEvent>

    fun downloadFile(
        fileId: Int,
        priority: Int = 1,
        offset: Long = 0,
        limit: Long = 0,
        synchronous: Boolean = false,
        userInitiated: Boolean = false
    )

    suspend fun cancelDownloadFile(fileId: Int)

    suspend fun getFilePath(fileId: Int): String?

    suspend fun getFileInfo(fileId: Int): FileModel?
}