package org.thoughtcrime.securesms.compose.core.ui

import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
object ExpressiveDefaults {
    @Composable
    fun largeButtonShapes(): ButtonShapes = ButtonShapes

    @Composable
    fun extraLargeButtonShapes(): ButtonShapes = ButtonShapes

    @Composable
    fun buttonShapesFor(height: Dp): ButtonShapes = ButtonShapes

    @Composable
    fun iconButtonShapes(): IconButtonShapes = IconButtonShapes
}
