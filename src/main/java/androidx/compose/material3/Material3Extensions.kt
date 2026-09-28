package androidx.compose.material3

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Typography.titleMediumEmphasized: TextStyle
    get() = titleMedium.copy(fontWeight = FontWeight.Bold)

val Typography.headlineSmallEmphasized: TextStyle
    get() = headlineSmall.copy(fontWeight = FontWeight.Bold)

object MotionScheme {
    val default: Any = Object()
    val fastEffects: Any = Object()
    val standardEffects: Any = Object()
    val expressive: Any = Object()
}

val MaterialTheme.motionScheme: MotionScheme
    @Composable
    get() = MotionScheme

object ButtonShapes {
    val round: Shape = RoundedCornerShape(50)
}

object IconButtonShapes {
    val round: Shape = RoundedCornerShape(50)
}

val ButtonDefaults.MediumContainerHeight: Dp
    get() = 48.dp

val ButtonDefaults.LargeIncreased: Dp
    get() = 56.dp

val Shape.Cookie4Sided: Shape
    get() = RoundedCornerShape(16.dp)

fun Shape.toShape(): Shape = this
fun ButtonShapes.toShape(): Shape = RoundedCornerShape(50)
fun IconButtonShapes.toShape(): Shape = RoundedCornerShape(50)
val ButtonShapes.shape: Shape get() = RoundedCornerShape(50)
val IconButtonShapes.shape: Shape get() = RoundedCornerShape(50)

object MaterialShapes {
    val extraSmall: Shape = RoundedCornerShape(4.dp)
    val small: Shape = RoundedCornerShape(8.dp)
    val medium: Shape = RoundedCornerShape(12.dp)
    val large: Shape = RoundedCornerShape(16.dp)
    val extraLarge: Shape = RoundedCornerShape(24.dp)

    val Sunny: Shape = RoundedCornerShape(16.dp)
    val VerySunny: Shape = RoundedCornerShape(16.dp)
    val Cookie4Sided: Shape = RoundedCornerShape(16.dp)
    val Cookie6Sided: Shape = RoundedCornerShape(16.dp)
    val Clover4Leaf: Shape = RoundedCornerShape(16.dp)
    val Clover8Leaf: Shape = RoundedCornerShape(16.dp)
    val Pentagon: Shape = RoundedCornerShape(16.dp)
    val Gem: Shape = RoundedCornerShape(16.dp)
    val Diamond: Shape = RoundedCornerShape(16.dp)
    val PuffyDiamond: Shape = RoundedCornerShape(16.dp)
    val Triangle: Shape = RoundedCornerShape(16.dp)
    val Slanted: Shape = RoundedCornerShape(16.dp)
    val Arrow: Shape = RoundedCornerShape(16.dp)
    val ClamShell: Shape = RoundedCornerShape(16.dp)
    val Ghostish: Shape = RoundedCornerShape(16.dp)
    val Burst: Shape = RoundedCornerShape(16.dp)
    val SoftBurst: Shape = RoundedCornerShape(16.dp)
    val Flower: Shape = RoundedCornerShape(16.dp)
    val PixelCircle: Shape = RoundedCornerShape(16.dp)
    val PixelTriangle: Shape = RoundedCornerShape(16.dp)
}

@Composable
fun LinearWavyProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Any? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = Color.Transparent
) {
    LinearProgressIndicator(modifier = modifier, color = color)
}

object ExposedDropdownMenuAnchorType {
    val PrimaryNotEditable: Any = Object()
    val SecondaryEditable: Any = Object()
}

@Composable
fun OutlinedToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Button(onClick = { onCheckedChange(!checked) }, modifier = modifier) {
        content()
    }
}

val MediumContainerHeight: Dp = 48.dp
val LargeIncreased: Dp = 56.dp

val TextStyle.titleMediumEmphasized: TextStyle get() = this.copy(fontWeight = FontWeight.Bold)
val TextStyle.headlineSmallEmphasized: TextStyle get() = this.copy(fontWeight = FontWeight.Bold)
