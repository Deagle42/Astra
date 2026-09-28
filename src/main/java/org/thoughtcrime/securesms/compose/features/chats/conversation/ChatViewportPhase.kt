package org.thoughtcrime.securesms.compose.features.chats.conversation

enum class ChatViewportPhase {
    Initializing,
    Restoring,
    Settled
}

enum class ChatRenderMode {
    Active,
    SwipePreview,
    ForumTopicSwipePreview,
}
