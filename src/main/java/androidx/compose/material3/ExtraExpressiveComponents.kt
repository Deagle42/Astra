package androidx.compose.material3

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun CircularWavyProgressIndicator(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(modifier = modifier)
}

object MaterialShapes {
    val extraSmall: Shape = RoundedCornerShape(4.dp)
    val small: Shape = RoundedCornerShape(8.dp)
    val medium: Shape = RoundedCornerShape(12.dp)
    val large: Shape = RoundedCornerShape(16.dp)
    val extraLarge: Shape = RoundedCornerShape(24.dp)
}
