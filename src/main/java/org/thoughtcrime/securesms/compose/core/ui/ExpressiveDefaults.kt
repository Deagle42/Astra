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
