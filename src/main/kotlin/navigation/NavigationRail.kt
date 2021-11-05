package navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import toColor

enum class MenuSelection {
    DASHBOARD, NOTIFICATION
}

@Composable
fun CustomNavigationRail() {
    val expanded = remember { mutableStateOf(true) }
    val w = animateDpAsState(if (expanded.value) 200.dp else 50.dp)

    val isSelected = remember { mutableStateOf(MenuSelection.DASHBOARD) }

    Card(elevation = 4.dp, backgroundColor = "#F1F4FB".toColor()) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.fillMaxHeight(1f)) {
                CustomIcon(Icons.Default.Home, "Dashboard", isSelected.value == MenuSelection.DASHBOARD) {
                    isSelected.value = MenuSelection.DASHBOARD
                }
                Spacer(modifier = Modifier.size(8.dp))
                CustomIcon(Icons.Default.Notifications, "Notifications", isSelected.value == MenuSelection.NOTIFICATION) {
                    isSelected.value = MenuSelection.NOTIFICATION
                }
            }
            ExpandIcon()
        }
    }
}

@Composable
private fun CustomIcon(
    icon: ImageVector,
    iconContentDescription: String,
    isSelected: Boolean,
    onClick: () -> Unit = {}
) {

    val color by animateColorAsState(
        if (isSelected) "#C5E6FD".toColor() else Color.Transparent,
        animationSpec = tween(durationMillis = 500)
    )

    Box(modifier = Modifier
        .size(50.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(color = color)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            onClick()
        }) {
        Icon(
            icon,
            contentDescription = iconContentDescription,
            modifier = Modifier.align(Alignment.Center),
            tint = "#011D35".toColor()
        )
    }
}

@Composable
private fun ExpandIcon() {
    Box(modifier = Modifier.size(50.dp).background(Color.Red))
}

@Preview
@Composable
fun DefaultPreview() {
    CustomNavigationRail()
}

