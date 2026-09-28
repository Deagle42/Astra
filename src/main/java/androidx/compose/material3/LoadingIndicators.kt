package androidx.compose.material3

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    progress: Any? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(0.dp)
) {
    CircularProgressIndicator(modifier = modifier, color = color)
}

@Composable
fun ContainedLoadingIndicator(
    modifier: Modifier = Modifier,
    progress: Any? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(0.dp)
) {
    CircularProgressIndicator(modifier = modifier, color = color)
}
