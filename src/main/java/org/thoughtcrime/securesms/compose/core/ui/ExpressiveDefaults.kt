package org.thoughtcrime.securesms.compose.core.ui

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
object ExpressiveDefaults {
    @Composable
    fun largeButtonShapes(): ButtonShapes =
        ButtonDefaults.RoundedCornerShape(ButtonDefaults.MediumContainerHeight)

    @Composable
    fun extraLargeButtonShapes(): ButtonShapes =
        ButtonDefaults.RoundedCornerShape(ButtonDefaults.LargeContainerHeight)

    @Composable
    fun buttonShapesFor(height: Dp): ButtonShapes =
        ButtonDefaults.RoundedCornerShape(height)

    @Composable
    fun iconButtonShapes(): IconButtonShapes = IconButtonDefaults.shapes()
}
