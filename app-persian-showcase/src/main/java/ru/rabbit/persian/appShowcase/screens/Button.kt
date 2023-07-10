package ru.rabbit.persian.appShowcase.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import ru.rabbit.persian.appShowcase.componets.SampleRow
import ru.rabbit.persian.appShowcase.componets.SampleScaffold
import ru.rabbit.persian.buttons.IconSide
import ru.rabbit.persian.buttons.PersianButton
import ru.rabbit.persian.buttons.PersianButtonSizes
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.icons

object Button : Screen {
    override val name: String = "Buttons"

    override val navigation: String = "button"

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressWarnings("LongMethod")
    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() },
            topAppBarScrollBehavior = topAppBarScrollBehavior,
        ) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
                contentPadding = it
            ) {
                //Primary
                item {
                    SampleRow(
                        text = "Primary Filled Button",
                        firstItem = true
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Filled with Leading Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Filled with Trailing Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Filled Disabled Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Filled Loading Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Outlined Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Outlined with Leading Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Outlined with Trailing Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Outlined Disabled Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Outlined Loading Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Standard Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Standard with Leading Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Standard with Trailing Icon Button",
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Standard Disabled Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Primary Standard Loading Button"
                    ) {
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Primary(
                            text = "Primary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                //Secondary
                item {
                    SampleRow(
                        text = "Secondary Filled Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Filled with Leading Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Filled with Trailing Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Filled Disabled Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Filled Loading Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Outlined Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Outlined with Leading Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Outlined with Trailing Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Outlined Disabled Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Outlined Loading Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Standard Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Standard with Leading Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Standard with Trailing Icon Button",
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Standard Disabled Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                             onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Secondary Standard Loading Button"
                    ) {
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Secondary(
                            text = "Secondary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                //Tertiary
                item {
                    SampleRow(
                        text = "Tertiary Filled Button",
                        firstItem = true,
                        lastItem = false
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Filled with Leading Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Filled with Trailing Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Filled Disabled Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Filled Loading Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined with Leading Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined with Trailing Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined Disabled Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined Loading Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Standard Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Standard with Leading Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Standard with Trailing Icon Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Standard Disabled Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Standard Loading Button"
                    ) {
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Tertiary(
                            text = "Tertiary",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                //Negative
                item {
                    SampleRow(
                        text = "Negative Filled Button",
                        firstItem = true,
                        lastItem = false
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Filled with Leading Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Filled with Trailing Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Filled Disabled Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Filled Loading Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Outlined Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Outlined with Leading Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Outlined with Trailing Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Outlined Disabled Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Outlined Loading Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Standard Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Standard with Leading Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Standard with Trailing Icon Button",
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Standard Disabled Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Negative Standard Loading Button"
                    ) {
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Negative(
                            text = "Negative",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                //Neutral
                item {
                    SampleRow(
                        text = "Neutral Filled Button",
                        firstItem = true,
                        lastItem = false
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Filled with Leading Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Filled with Trailing Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Filled Disabled Button"
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Filled Loading Button"
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.FILL,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Outlined Button",
                    ) {
                        PersianButton.Tertiary(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Outlined with Leading Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Tertiary Outlined with Trailing Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Outlined Disabled Button"
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Outlined Loading Button"
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.OUTLINED,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Standard Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Standard with Leading Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.LEFT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Standard with Trailing Icon Button",
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.large(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.medium(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            size = PersianButtonSizes.small(),
                            icon = MaterialTheme.icons.add,
                            iconSide = IconSide.RIGHT,
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Standard Disabled Button"
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            enabled = false,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
                item {
                    SampleRow(
                        text = "Neutral Standard Loading Button",
                        lastItem = true
                    ) {
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.large(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.medium(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                        PersianButton.Neutral(
                            text = "Neutral",
                            loading = true,
                            size = PersianButtonSizes.small(),
                            style = PersianComponentStyle.STANDARD,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}