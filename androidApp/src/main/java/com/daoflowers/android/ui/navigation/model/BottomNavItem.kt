package com.daoflowers.android.ui.navigation.model

import com.daoflowers.navigation.domain.model.BottomNavItem
import com.daoflowers.sharing_resources.SharedRes
import dev.icerock.moko.resources.StringResource

data class BottomItemUI(
    val id: BottomNavItem,
    val route: String,
    val title: StringResource,
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
        BottomNavItem.Main -> SharedRes.images.Home.drawableResId
        BottomNavItem.Contacts -> SharedRes.images.Contacts.drawableResId
        BottomNavItem.Menu -> SharedRes.images.Category.drawableResId
    }
}

fun BottomNavItem.toNavString(): StringResource {
    return when (this) {
        BottomNavItem.Main -> SharedRes.strings.main
        BottomNavItem.Contacts -> SharedRes.strings.contacts
        BottomNavItem.Menu -> SharedRes.strings.menu
    }
}

fun BottomNavItem.toRoute(): String {
    return when (this) {
        BottomNavItem.Main -> "main"
        BottomNavItem.Contacts -> "contacts"
        BottomNavItem.Menu -> "menu"
    }
}