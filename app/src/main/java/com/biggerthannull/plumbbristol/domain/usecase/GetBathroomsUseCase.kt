package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview

interface GetBathroomsUseCase {
    suspend fun execute(): List<BathroomOverview>
}