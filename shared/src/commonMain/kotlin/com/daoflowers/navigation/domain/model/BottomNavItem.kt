package com.daoflowers.navigation.domain.model

sealed interface BottomNavItem {
    object Main : BottomNavItem
    object Contacts : BottomNavItem
    object Menu : BottomNavItem
}