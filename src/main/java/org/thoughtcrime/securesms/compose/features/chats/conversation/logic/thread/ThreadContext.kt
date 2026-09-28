package org.thoughtcrime.securesms.compose.features.chats.conversation.logic

import org.thoughtcrime.securesms.compose.domain.models.MessageModel
import org.thoughtcrime.securesms.compose.domain.repository.ConversationKey
import org.thoughtcrime.securesms.compose.domain.repository.ConversationScope
import org.thoughtcrime.securesms.compose.features.chats.conversation.ChatComponent
import org.thoughtcrime.securesms.compose.features.chats.conversation.DefaultChatComponent

internal fun ChatComponent.State.effectiveThreadChatId(baseChatId: Long): Long {
    return currentThreadChatId ?: baseChatId
}

internal fun ChatComponent.State.effectiveThreadId(): Long? {
    return currentMessageThreadId ?: currentTopicId
}

internal fun ChatComponent.State.isMessageInActiveThread(
    baseChatId: Long,
    message: MessageModel
): Boolean {
    val targetThreadId =
        effectiveThreadId() ?: return message.chatId == effectiveThreadChatId(baseChatId)
    return message.chatId == effectiveThreadChatId(baseChatId) && message.threadId == targetThreadId
}

internal fun DefaultChatComponent.activeThreadChatId(): Long =
    _state.value.effectiveThreadChatId(chatId)

internal fun DefaultChatComponent.activeThreadId(): Long? = _state.value.effectiveThreadId()

internal fun DefaultChatComponent.historyConversationKey(
    targetChatId: Long,
    threadId: Long?
): ConversationKey {
    val state = _state.value
    val scope = when {
        threadId == null -> ConversationScope.Main
        state.currentMessageThreadId == threadId || state.rootMessage != null ->
            ConversationScope.MessageThread(threadId)

        else -> ConversationScope.ForumTopic(threadId)
    }
    return ConversationKey(targetChatId, scope)
}
