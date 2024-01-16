package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview

interface GetBathroomsUseCase {
    fun execute(): List<BathroomOverview>
}