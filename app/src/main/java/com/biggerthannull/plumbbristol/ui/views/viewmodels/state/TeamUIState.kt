package com.biggerthannull.plumbbristol.ui.views.viewmodels.state

import com.biggerthannull.plumbbristol.domain.usecase.models.Employee

sealed class TeamUIState {
    data object Loading: TeamUIState()
    class Success(val data: List<Employee>): TeamUIState()
    data object Failed: TeamUIState()
}