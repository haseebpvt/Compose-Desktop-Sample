import androidx.compose.animation.animateColorAsState
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.CustomNavigationRail

@ExperimentalUnitApi
@Composable
@Preview
fun App() {
    DesktopMaterialTheme {
        Row {
            CustomNavigationRail()
            Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
                Text("Dashboard", fontSize = TextUnit(24f, TextUnitType.Sp), fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.size(32.dp))
                UserInfo()
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun TestComponent() {
    var flag by remember { mutableStateOf(false) }
    val color = animateColorAsState(if (flag) Color.Red else Color.Green)
    Box(modifier = Modifier.size(50.dp).clickable {
        flag = !flag
    }.background(color.value))
}