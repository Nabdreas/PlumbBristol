package com.biggerthannull.plumbbristol.ui.views.viewmodels.state

import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoveredBathrooms

sealed class DiscoverUIState {
    data object Loading : DiscoverUIState()
    data object Error : DiscoverUIState()
    class Success(val bathrooms: List<DiscoveredBathrooms>) : DiscoverUIState()
}