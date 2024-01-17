package com.biggerthannull.plumbbristol.ui.views.viewmodels.state

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails

sealed class BathroomDetailsUIState {
    data object Loading : BathroomDetailsUIState()
    data object Error : BathroomDetailsUIState()
    class Success(val bathroom: BathroomDetails) : BathroomDetailsUIState()
}