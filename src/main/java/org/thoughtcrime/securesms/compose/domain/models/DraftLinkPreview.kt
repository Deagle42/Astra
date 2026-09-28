package org.thoughtcrime.securesms.compose.domain.models

data class DraftLinkPreview(
    val sourceUrl: String,
    val resolvedUrl: String,
    val webPage: WebPage
)

data class DraftLinkPreviewRequest(
    val sourceUrl: String,
    val useFixedPreview: Boolean
)
