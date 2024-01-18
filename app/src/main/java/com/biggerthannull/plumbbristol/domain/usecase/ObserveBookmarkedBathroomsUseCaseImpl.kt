package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BookmarksRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveBookmarkedBathroomsUseCaseImpl @Inject constructor(
    private val repository: BookmarksRepository
): ObserveBookmarkedBathroomsUseCase {
    override suspend fun execute(): Flow<List<BathroomDetails>> {
        return repository.observeBookmarkedBathrooms()
    }
}