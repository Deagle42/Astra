package org.thoughtcrime.securesms.compose.features.webview

interface WebViewComponent {
    val url: String
    fun onDismiss()
}