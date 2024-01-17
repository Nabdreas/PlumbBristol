package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult

interface GetBathroomDetailsUseCase {
    suspend fun execute(bathroomId: String): BathroomDetailsResult
}