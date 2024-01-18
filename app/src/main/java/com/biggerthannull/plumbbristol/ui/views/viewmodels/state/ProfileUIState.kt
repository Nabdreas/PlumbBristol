package com.biggerthannull.plumbbristol.ui.views.viewmodels.state

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails

sealed class ProfileUIState {
    data object Loading: ProfileUIState()

    class Success(val bookmarked: List<BathroomDetails>): ProfileUIState()

    data object Error: ProfileUIState()
}