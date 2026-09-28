package org.thoughtcrime.securesms.compose.features.webview

import org.thoughtcrime.securesms.compose.root.AppComponentContext

class DefaultWebViewComponent(
    context: AppComponentContext,
    override val url: String,
    private val onDismiss: () -> Unit
) : WebViewComponent, AppComponentContext by context {
    override fun onDismiss() = onDismiss.invoke()
}