package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import kotlinx.coroutines.flow.Flow

interface ObserveBookmarkedBathroomsUseCase {
    suspend fun execute(): Flow<List<BathroomDetails>>
}