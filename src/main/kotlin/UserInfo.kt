import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp

@Composable
fun UserInfo() {

    val entered = remember { mutableStateOf(false) }

    val cardElevation by animateDpAsState(if (entered.value) 24.dp else 0.dp)

    Card(
        elevation = cardElevation,
        modifier = Modifier.pointerMoveFilter(onEnter = {
        entered.value = true
        true
    }, onExit = {
        entered.value = false
        true
    })) {
        Box(modifier = Modifier.size(200.dp))
    }
}