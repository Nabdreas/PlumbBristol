package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails

interface AddBathroomToBookmarksUseCase {
    suspend fun execute(details: BathroomDetails)
}