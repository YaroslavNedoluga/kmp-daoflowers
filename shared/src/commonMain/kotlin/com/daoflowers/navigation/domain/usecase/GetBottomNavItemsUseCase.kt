package com.daoflowers.navigation.domain.usecase

import com.daoflowers.navigation.domain.model.BottomNavItem
import com.daoflowers.navigation.domain.model.BottomNavItem.Contacts
import com.daoflowers.navigation.domain.model.BottomNavItem.Main
import com.daoflowers.navigation.domain.model.BottomNavItem.Menu
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class GetBottomNavItemsUseCase {
    suspend operator fun invoke(): ImmutableList<BottomNavItem> {
        return persistentListOf(
            Main, Contacts, Menu
        )
    }
}