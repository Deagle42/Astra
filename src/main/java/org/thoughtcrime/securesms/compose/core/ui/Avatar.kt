package org.thoughtcrime.securesms.compose.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun rememberAnimatedAvatarPlaybackEnabled(): Boolean = true

@Composable
fun PlaceholderAvatar(
    name: String = "",
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    val initial = name.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = (size.value * 0.45f).sp
        )
    }
}

@Composable
fun Avatar(
    model: Any? = null,
    path: Any? = null,
    fallbackPath: Any? = null,
    name: String = "",
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    fontSize: Any? = null,
    isOnline: Boolean = false,
    isLocal: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val clickModifier = if (onClick != null) modifier.clickable { onClick() } else modifier
    val resolvedModel = model ?: path ?: fallbackPath
    if (resolvedModel != null && resolvedModel.toString().isNotBlank()) {
        AsyncImage(
            model = resolvedModel,
            contentDescription = name,
            modifier = clickModifier
                .size(size)
                .clip(CircleShape)
        )
    } else {
        PlaceholderAvatar(name = name, modifier = clickModifier, size = size)
    }
}

@Composable
fun AvatarForChat(
    chat: Any? = null,
    path: Any? = null,
    fallbackPath: Any? = null,
    name: String = "",
    isOnline: Boolean = false,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    onClick: (() -> Unit)? = null
) {
    Avatar(model = chat, path = path, fallbackPath = fallbackPath, name = name.ifBlank { chat?.toString() ?: "" }, isOnline = isOnline, modifier = modifier, size = size, onClick = onClick)
}

@Composable
fun AvatarTopAppBar(
    chat: Any? = null,
    path: Any? = null,
    fallbackPath: Any? = null,
    name: String = "",
    isOnline: Boolean = false,
    modifier: Modifier = Modifier,
    size: Dp = 36.dp,
    onClick: (() -> Unit)? = null
) {
    AvatarForChat(chat = chat, path = path, fallbackPath = fallbackPath, name = name, isOnline = isOnline, modifier = modifier, size = size, onClick = onClick)
}
