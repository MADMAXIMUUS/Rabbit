package ru.madmax.composetwitterclone.navigation

enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val iconTextId: Int,
) {
    FEED(
        selectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_feed_filled,
        unselectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_feed_outline,
        iconTextId = 0,
    ),
    SEARCH(
        selectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_search_filled,
        unselectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_search_outline,
        iconTextId = 0,
    ),
    NOTIFICATION(
        selectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_notifications_filled,
        unselectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_notifications_outline,
        iconTextId = 0,
    ),
    MESSAGES(
        selectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_message_filled,
        unselectedIcon = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_message_outline,
        iconTextId = 0,
    ),
}