package org.thoughtcrime.securesms.compose.features.share

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
enum class PendingAttachmentKind  {
    PHOTO,
    VIDEO,
    GIF,
    DOCUMENT;

    val isAlbumMedia: Boolean
        get() = this == PHOTO || this == VIDEO

    val isVisualMedia: Boolean
        get() = this == PHOTO || this == VIDEO || this == GIF
}


@Serializable
data class PendingAttachment(
    val localPath: String,
    val kind: PendingAttachmentKind,
    val deleteAfterUse: Boolean = false
) 


@Serializable
data class IncomingShareRequest(
    val requestId: Long,
    val text: String = "",
    val attachments: List<PendingAttachment> = emptyList()
) 


@Serializable
data class ShareTarget(
    val chatId: Long,
    val topicId: Long? = null
) 

val PendingAttachment.isDocument: Boolean
    get() = kind == PendingAttachmentKind.DOCUMENT

val PendingAttachment.isMedia: Boolean
    get() = !isDocument

private val VIDEO_ATTACHMENT_EXTENSIONS = setOf(
    "mp4",
    "mov",
    "m4v",
    "webm",
    "mkv",
    "3gp",
    "avi"
)

fun inferPendingAttachmentKind(
    localPath: String,
    mimeType: String? = null
): PendingAttachmentKind {
    val normalizedMimeType = mimeType
        ?.substringBefore(';')
        ?.trim()
        ?.lowercase()
    if (normalizedMimeType == "image/gif") return PendingAttachmentKind.GIF
    if (normalizedMimeType?.startsWith("video/") == true) return PendingAttachmentKind.VIDEO

    val normalizedPath = localPath.lowercase()
    return when {
        normalizedPath.endsWith(".gif") -> PendingAttachmentKind.GIF
        VIDEO_ATTACHMENT_EXTENSIONS.any { extension ->
            normalizedPath.endsWith(".$extension")
        } -> PendingAttachmentKind.VIDEO

        else -> PendingAttachmentKind.PHOTO
    }
}
