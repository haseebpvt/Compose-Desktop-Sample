import androidx.compose.ui.graphics.Color

fun String.toColor(): Color {
    val color = java.awt.Color.decode(this)
    return Color(color.red, color.green, color.blue)
}