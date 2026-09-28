package org.thoughtcrime.securesms.compose.domain.repository

interface MessageDisplayer {
    fun show(message: String)
}