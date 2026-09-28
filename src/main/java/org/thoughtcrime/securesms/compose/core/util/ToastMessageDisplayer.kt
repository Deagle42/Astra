package org.thoughtcrime.securesms.compose.core.util

import android.content.Context
import android.widget.Toast
import org.thoughtcrime.securesms.compose.domain.repository.MessageDisplayer

class ToastMessageDisplayer(private val context: Context) : MessageDisplayer {
    override fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun show(messageResId: Int) {
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
    }
}
