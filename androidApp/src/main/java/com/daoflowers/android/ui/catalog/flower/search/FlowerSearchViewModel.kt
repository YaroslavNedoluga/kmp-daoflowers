package com.daoflowers.android.ui.catalog.flower.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daoflowers.catalog.domain.flower.SearchFlowersUseCase
import com.daoflowers.catalog.ui.flower.search.FlowerSearchItem
import com.daoflowers.catalog.ui.flower.search.FlowerSearchMapper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlowerSearchViewModel constructor(
    private val searchFlowersUseCase: SearchFlowersUseCase,
    private val mapper: FlowerSearchMapper
) : ViewModel() {

    private val _state: MutableStateFlow<SearchState> = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    // TODO: Improve this
    private var searchJob: Job? = null

    fun onSideEffect(sideEffect: SideEffect) {
        when (sideEffect) {
            is SideEffect.SearchChanged ->
                handleSearchChanged(sideEffect.value)

            is SideEffect.SearchItemClicked -> {

            }
        }
    }

    private fun handleSearchChanged(value: String) {
        _state.update {
            it.copy(
                value = value,
                searching = it.searchItems.isEmpty()
            )
        }

        searchJob?.cancel()
        searchJob =
            viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
                _state.update {
                    it.copy(
                        searchItems = persistentListOf(),
                        searching = false,
                        searchingFailed = true
                    )
                }
            }) {
                _state.update {
                    it.copy(
                        value = value,
                        searchItems = mapper.map(searchFlowersUseCase(value)),
                        searching = false,
                        searchingFailed = false,
                    )
                }
            }
    }

    data class SearchState(
        val value: String = "",
        val searchItems: ImmutableList<FlowerSearchItem> = persistentListOf(),
        val searching: Boolean = false,
        val searchingFailed: Boolean = false
    ) {
        val showSearchItems: Boolean
            get() = value.isNotBlank() && value.length >= 3

        val showEmptyResults: Boolean
            get() = showSearchItems && searchItems.isEmpty() && !searching && !searchingFailed
    }

    sealed class SideEffect {
        data class SearchChanged(val value: String) : SideEffect()
        data class SearchItemClicked(val item: FlowerSearchItem) : SideEffect()
    }
}