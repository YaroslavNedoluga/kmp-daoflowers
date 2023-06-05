package com.daoflowers.android.ui.navigation.model

import com.daoflowers.android.R
import com.daoflowers.navigation.domain.model.BottomNavItem

data class BottomItemUI(
    val id: BottomNavItem,
    val route: String,
    val title: Int,
    val icon: Int
)

fun BottomNavItem.toBottomItemUI(): BottomItemUI {
    return BottomItemUI(
        id = this,
        route = toRoute(),
        title = toNavString(),
        icon = toNavIcon()
    )
}

fun BottomNavItem.toNavIcon(): Int {
    return when (this) {
        BottomNavItem.Main -> R.drawable.ic_home
        BottomNavItem.Contacts -> R.drawable.ic_users
        BottomNavItem.Menu -> R.drawable.ic_menu
    }
}

fun BottomNavItem.toNavString(): Int {
    return when (this) {
        BottomNavItem.Main -> R.string.main
        BottomNavItem.Contacts -> R.string.contacts
        BottomNavItem.Menu -> R.string.menu
    }
}

fun BottomNavItem.toRoute(): String {
    return when (this) {
        BottomNavItem.Main -> "main"
        BottomNavItem.Contacts -> "contacts"
        BottomNavItem.Menu -> "menu"
    }
}