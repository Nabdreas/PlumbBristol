package com.biggerthannull.plumbbristol.ui.views.viewmodels.state

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview

data class HomeScreenUIState(
    val bathrooms: List<BathroomOverview> = emptyList(),
    val bathroomsCompleted: Int = 0
)
