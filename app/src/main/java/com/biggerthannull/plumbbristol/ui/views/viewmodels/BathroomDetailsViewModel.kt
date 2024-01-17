package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import com.biggerthannull.plumbbristol.ui.navigation.models.NavArguments
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BathroomDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBathroomDetailsUseCase: GetBathroomDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BathroomDetailsUIState>(BathroomDetailsUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        val bathroomId = savedStateHandle.get<String>(NavArguments.BATHROOM_ID).orEmpty()
        if (bathroomId.isNotEmpty()) {
            viewModelScope.launch {
                val result = getBathroomDetailsUseCase.execute(bathroomId)
                if (result is BathroomDetailsResult.Success) {
                    _uiState.value = BathroomDetailsUIState.Success(
                        BathroomDetails(
                            title = result.data.title,
                            description = result.data.description,
                            price = result.data.price,
                            duration = result.data.duration,
                            gallery = result.data.gallery
                        )
                    )
                } else {
                    _uiState.value = BathroomDetailsUIState.Error
                }
            }
        } else {
            _uiState.value = BathroomDetailsUIState.Error
        }
    }
}