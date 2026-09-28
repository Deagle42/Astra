package org.thoughtcrime.securesms.compose.domain.managers

interface ClipManager {
    fun copyToClipboard(tag: String, text: String)
}