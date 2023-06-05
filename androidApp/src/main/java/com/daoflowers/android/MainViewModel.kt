package com.daoflowers.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daoflowers.android.ui.navigation.model.BottomItemUI
import com.daoflowers.android.ui.navigation.model.toBottomItemUI
import com.daoflowers.navigation.domain.usecase.GetBottomNavItemsUseCase
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val getBottomNavItemsUseCase: GetBottomNavItemsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state

    init {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    items = getBottomNavItemsUseCase()
                        .map { it.toBottomItemUI() }
                        .toPersistentList(),
                    isLoading = false
                )
            }
        }
    }

    data class State(
        val items: ImmutableList<BottomItemUI> = persistentListOf(),
        val isLoading: Boolean = true,
        val error: Throwable? = null
    )
}