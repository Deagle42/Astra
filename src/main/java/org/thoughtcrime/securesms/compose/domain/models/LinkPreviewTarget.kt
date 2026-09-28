package org.thoughtcrime.securesms.compose.domain.models

data class LinkPreviewTarget(
    val sourceUrl: String,
    val normalizedUrl: String,
    val displayLabel: String,
    val host: String
)
