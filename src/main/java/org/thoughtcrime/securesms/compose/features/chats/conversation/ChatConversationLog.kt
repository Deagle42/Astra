package org.thoughtcrime.securesms.compose.features.chats.conversation

object ChatConversationLog {
    const val STREAM_VIEWPORT = "viewport"
    fun d(tag: String, msg: String) {}
    fun e(tag: String, msg: String) {}
    fun i(tag: String, msg: String) {}
    fun nextUiInstanceId(): Long = 0L
    fun logState(stream: String, vararg args: Any?) {}
}

val DefaultChatComponent.componentInstanceId: Long get() = 0L
