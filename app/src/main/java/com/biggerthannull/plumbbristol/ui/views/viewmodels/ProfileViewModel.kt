package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.plumbbristol.domain.usecase.ObserveBookmarkedBathroomsUseCase
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.ProfileUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val observeBookmarkedBathroomsUseCase: ObserveBookmarkedBathroomsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileUIState>(ProfileUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            observeBookmarkedBathroomsUseCase.execute().collect { bookmarks ->
                _uiState.value = ProfileUIState.Success(bookmarked = bookmarks)
            }

        }
    }
}