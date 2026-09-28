package org.thoughtcrime.securesms.compose.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
    name: String,
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
    model: Any?,
    name: String = "",
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    if (model != null && model.toString().isNotBlank()) {
        AsyncImage(
            model = model,
            contentDescription = name,
            modifier = modifier
                .size(size)
                .clip(CircleShape)
        )
    } else {
        PlaceholderAvatar(name = name, modifier = modifier, size = size)
    }
}

@Composable
fun AvatarForChat(
    chat: Any?,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    Avatar(model = null, name = chat?.toString() ?: "", modifier = modifier, size = size)
}

@Composable
fun AvatarTopAppBar(
    chat: Any?,
    modifier: Modifier = Modifier,
    size: Dp = 36.dp
) {
    AvatarForChat(chat = chat, modifier = modifier, size = size)
}
