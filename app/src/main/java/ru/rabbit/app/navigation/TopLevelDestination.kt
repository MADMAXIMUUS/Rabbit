package ru.rabbit.app.navigation

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter
import ru.rabbit.persian.foundation.icons

@Immutable
data class NavItemInfo(
    val selected: Boolean = false,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    @StringRes val textId: Int,
    val onClick: () -> Boolean
)

object NavBarDestinations {

    @Composable
    fun feed() = NavItemInfo(
        selectedIcon = MaterialTheme.icons.homeFilled,
        unselectedIcon = MaterialTheme.icons.homeOutlined,
        textId = 0,
        onClick = { return@NavItemInfo true }
    )

    @Composable
    fun search() = NavItemInfo(
        selectedIcon = MaterialTheme.icons.searchFilled,
        unselectedIcon = MaterialTheme.icons.searchOutlined,
        textId = 0,
        onClick = { return@NavItemInfo true }
    )

    @Composable
    fun messages() = NavItemInfo(
        selectedIcon = MaterialTheme.icons.mailFilled,
        unselectedIcon = MaterialTheme.icons.mailOutlined,
        textId = 0,
        onClick = { return@NavItemInfo true }
    )


    @Composable
    fun profile() = NavItemInfo(
        selectedIcon = MaterialTheme.icons.personFilled,
        unselectedIcon = MaterialTheme.icons.personOutlined,
        textId = 0,
        onClick = { return@NavItemInfo true }
    )
}