package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import javax.inject.Inject

class GetBathroomsUseCaseImpl @Inject constructor(
    private val repo: BathroomsRepository
): GetBathroomsUseCase {
    override suspend fun execute(): List<BathroomOverview> {
        return repo.getBathrooms()
    }
}