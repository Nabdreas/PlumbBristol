package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.plumbbristol.domain.usecase.GetInspirationalImagesUseCase
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.DiscoverUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getInspirationalImagesUseCase: GetInspirationalImagesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<DiscoverUIState>(DiscoverUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val result = getInspirationalImagesUseCase.execute()
            _uiState.value = if (result is DiscoverBathroomsResult.Success) {
                DiscoverUIState.Success(
                    bathrooms = result.data
                )
            } else {
                DiscoverUIState.Error
            }
        }
    }

}