package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult
import javax.inject.Inject

class GetInspirationalImagesUseCaseImpl @Inject constructor(
    private val bathroomsRepository: BathroomsRepository
): GetInspirationalImagesUseCase {
    override suspend fun execute(): DiscoverBathroomsResult {
        return bathroomsRepository.discoverBathrooms()
    }
}