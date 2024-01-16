package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.ViewModel
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCase
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.HomeScreenUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bathroomsUseCase: GetBathroomsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        val result = bathroomsUseCase.execute()
        _uiState.update {
            it.copy(bathrooms = result)
        }
    }

}