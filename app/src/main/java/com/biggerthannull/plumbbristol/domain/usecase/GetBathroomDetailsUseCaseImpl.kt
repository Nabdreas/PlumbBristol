package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import javax.inject.Inject

class GetBathroomDetailsUseCaseImpl @Inject constructor(
    private val bathroomsRepository: BathroomsRepository
): GetBathroomDetailsUseCase {
    override suspend fun execute(bathroomId: String): BathroomDetailsResult {
        return bathroomsRepository.getBathroomDetails(bathroomId)
    }
}