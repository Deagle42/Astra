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

object ButtonDefaultsExpressive {
    val MediumContainerHeight: Dp = 48.dp
    val LargeIncreased: Dp = 56.dp
}

val Shape.Cookie4Sided: Shape
    get() = RoundedCornerShape(16.dp)

fun Shape.toShape(): Shape = this

val ButtonDefaults.MediumContainerHeight: Dp
    get() = 48.dp

val ButtonDefaults.LargeIncreased: Dp
    get() = 56.dp

fun ButtonShapes.toShape(): Shape = RoundedCornerShape(50)
fun IconButtonShapes.toShape(): Shape = RoundedCornerShape(50)
val ButtonShapes.shape: Shape get() = RoundedCornerShape(50)
val IconButtonShapes.shape: Shape get() = RoundedCornerShape(50)
