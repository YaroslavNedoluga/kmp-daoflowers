package com.daoflowers.android.ui.catalog.flower

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daoflowers.catalog.data.model.FlowerType
import com.daoflowers.catalog.domain.flower.GetFlowerTypesUseCase
import com.daoflowers.catalog.ui.flower.FlowerTypeItem
import com.daoflowers.catalog.ui.flower.FlowerTypeMapper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.security.PrivateKey

class FlowerTypesViewModel constructor(
    private val getFlowerTypesUseCase: GetFlowerTypesUseCase,
    private val mapper: FlowerTypeMapper
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO + doOnError()) {
            _state.update {
                it.copy(
                    flowerTypes = mapper.map(getFlowerTypesUseCase()),
                    isLoading = false
                )
            }
        }
    }

    fun onSideEffect(sideEffect: SideEffect) {
        when (sideEffect) {
            is SideEffect.ShowFlowerSorts -> {
                // TODO: Show flower sorts
            }
        }
    }

    private fun doOnError(): CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            // todo: Add logging
        }

    data class State(
        val flowerTypes: ImmutableList<FlowerTypeItem> = persistentListOf(),
        val isLoading: Boolean = true,
        val error: Throwable? = null
    )

    sealed class SideEffect {
        data class ShowFlowerSorts(val flowerType: FlowerTypeItem) : SideEffect()
    }
}