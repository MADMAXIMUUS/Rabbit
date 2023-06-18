package ru.rabbit.persian.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import ru.rabbit.persian.components.TTextButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopAppBar(
    title: @Composable () -> Unit,
    navigationIcon: Painter,
    navigationIconContentDescription: String?,
    actionIcon: Painter,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { title() },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    painter = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = actionIcon,
                    contentDescription = actionIconContentDescription,
                )
            }
        },
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopAppBar(
    title: @Composable () -> Unit,
    navigationIcon: Painter,
    navigationIconContentDescription: String?,
    actionText: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { title() },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    painter = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                )
            }
        },
        actions = {
            TTextButton(onClick = onActionClick) {
                Text(text = actionText)
            }
        },
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopAppBarNavigationOnly(
    title: @Composable () -> Unit,
    navigationIcon: Painter,
    navigationIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = title,
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    painter = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                )
            }
        },
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopAppBarActionOnly(
    title: @Composable () -> Unit,
    actionIcon: Painter,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { title() },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = actionIcon,
                    contentDescription = actionIconContentDescription,
                )
            }
        },
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { title() },
        colors = colors,
    )
}