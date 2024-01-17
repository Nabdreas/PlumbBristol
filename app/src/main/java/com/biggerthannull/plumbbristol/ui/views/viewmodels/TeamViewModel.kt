package com.biggerthannull.plumbbristol.ui.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.plumbbristol.domain.usecase.GetTeamUseCase
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.TeamUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamUseCase: GetTeamUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<TeamUIState>(TeamUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val result = getTeamUseCase.execute()
            _uiState.value = TeamUIState.Success(result)
        }
    }
}