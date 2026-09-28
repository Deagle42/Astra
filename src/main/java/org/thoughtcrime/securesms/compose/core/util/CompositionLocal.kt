package org.thoughtcrime.securesms.compose.core.util

import androidx.compose.runtime.staticCompositionLocalOf
import org.thoughtcrime.securesms.compose.core.media.VideoPlayerPool

val LocalVideoPlayerPool = staticCompositionLocalOf<VideoPlayerPool> {
    error("VideoPlayerPool not provided")
}

val LocalTabletInterfaceEnabled = staticCompositionLocalOf { true }

import androidx.compose.runtime.staticCompositionLocalOf
import java.util.Locale

val LocalLocale = staticCompositionLocalOf { Locale.getDefault() }
