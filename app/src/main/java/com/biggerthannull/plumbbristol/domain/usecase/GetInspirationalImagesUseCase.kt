package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult

interface GetInspirationalImagesUseCase {
    suspend fun execute(): DiscoverBathroomsResult
}