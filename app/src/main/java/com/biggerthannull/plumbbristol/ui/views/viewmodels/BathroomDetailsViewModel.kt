package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.ui.navigation.models.NavArguments
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BathroomDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _uiState = MutableStateFlow<BathroomDetailsUIState>(BathroomDetailsUIState.Loading)
    val uiState = _uiState.asStateFlow()
    init {
        val bathroomId = savedStateHandle.get<String>(NavArguments.BATHROOM_ID).orEmpty()
        if (bathroomId.isNotEmpty()) {
            _uiState.value = BathroomDetailsUIState.Success(
                BathroomDetails(
                    title = bathroomId,
                    description = "test",
                    price = "142",
                    duration = "6 days",
                    gallery = emptyList()
                )
            )
        } else {
            _uiState.value = BathroomDetailsUIState.Error
        }
    }
}