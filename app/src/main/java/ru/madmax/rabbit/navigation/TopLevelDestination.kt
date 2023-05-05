package ru.madmax.rabbit.navigation

enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val iconTextId: Int,
) {
    FEED(
        selectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_feed_filled,
        unselectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_feed_outline,
        iconTextId = 0,
    ),
    SEARCH(
        selectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_search_filled,
        unselectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_search_outline,
        iconTextId = 0,
    ),
    NOTIFICATION(
        selectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_notifications_filled,
        unselectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_notifications_outline,
        iconTextId = 0,
    ),
    MESSAGES(
        selectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_message_filled,
        unselectedIcon = ru.madmax.rabbit.core.ui.R.drawable.ic_message_outline,
        iconTextId = 0,
    ),
}