package androidx.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LinearWavyProgressIndicator(
    modifier: Modifier = Modifier,
    progress: () -> Float = { 0f },
    color: Color = Color.Unspecified,
    trackColor: Color = Color.Unspecified
) {
    LinearProgressIndicator(modifier = modifier)
}

val MaterialTheme.motionScheme: MotionScheme
    @Composable get() = MotionScheme

object MotionScheme {
    val defaultSpatialSpec = androidx.compose.animation.core.spring<Float>()
    val fastSpatialSpec = androidx.compose.animation.core.spring<Float>()
    val slowSpatialSpec = androidx.compose.animation.core.spring<Float>()
}

val AppBarMediumContainerHeight: Dp = 64.dp
val MediumContainerHeight: Dp = 64.dp
