package ru.rabbit.persian.topAppBar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.rabbit.persian.foundation.PersianTheme
import ru.rabbit.persian.foundation.icons

object PersianTopAppBar {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        topAppBarColors: TopAppBarColors = PersianTopAppBarColors.primary(),
        windowInsets: WindowInsets,
        left: (@Composable PersianTopAppBarLeft.() -> Unit)? = null,
        middle: @Composable PersianTopAppBarMiddle.() -> Unit,
        right: (@Composable PersianTopAppBarRight.() -> Unit)? = null,
        scrollBehavior: TopAppBarScrollBehavior? = null,
        actionsCount: Int,
    ) {
        CompositionLocalProvider(LocalPersianTopAppBarColors provides topAppBarColors) {
            val colors = LocalPersianTopAppBarColors.current
            if (actionsCount < 2) {
                CenterAlignedTopAppBar(
                    modifier = modifier,
                    title = {
                        PersianTopAppBarMiddle.middle()
                    },
                    navigationIcon = {
                        if (left != null) {
                            PersianTopAppBarLeft.left()
                        }
                    },
                    actions = {
                        if (right != null) {
                            PersianTopAppBarRight.right()
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = colors.background,
                        scrolledContainerColor = colors.scrolledBackgroundColor
                    ),
                    windowInsets = windowInsets
                )
            } else {
                TopAppBar(
                    modifier = modifier,
                    title = {
                        PersianTopAppBarMiddle.middle()
                    },
                    navigationIcon = {
                        if (left != null) {
                            PersianTopAppBarLeft.left()
                        }
                    },
                    actions = {
                        if (right != null) {
                            PersianTopAppBarRight.right()
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = colors.background,
                        scrolledContainerColor = colors.scrolledBackgroundColor
                    ),
                    windowInsets = windowInsets
                )

            }
        }
    }
}