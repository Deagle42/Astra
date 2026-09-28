package org.thoughtcrime.securesms.compose.core.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
object ExpressiveDefaults {
    @Composable
    fun largeButtonShapes(): Shape = RoundedCornerShape(50)

    @Composable
    fun extraLargeButtonShapes(): Shape = RoundedCornerShape(50)

    @Composable
    fun buttonShapesFor(height: Dp): Shape = RoundedCornerShape(50)

    @Composable
    fun iconButtonShapes(): Shape = RoundedCornerShape(50)
}

val MediumContainerHeight: Dp = 48.dp
val LargeIncreased: Dp = 56.dp

val TextStyle.titleMediumEmphasized: TextStyle get() = this.copy(fontWeight = FontWeight.Bold)
val TextStyle.headlineSmallEmphasized: TextStyle get() = this.copy(fontWeight = FontWeight.Bold)


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

@Composable
fun CircularWavyProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Any? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = Color.Transparent
) {
    CircularProgressIndicator(modifier = modifier, color = color)
}


import androidx.compose.material3.MotionScheme

val MaterialTheme.motionScheme: MotionScheme
    @Composable
    get() = MotionScheme
