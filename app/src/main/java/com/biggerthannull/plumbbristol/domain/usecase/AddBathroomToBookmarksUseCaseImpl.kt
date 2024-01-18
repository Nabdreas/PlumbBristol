package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BookmarksRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import javax.inject.Inject

class AddBathroomToBookmarksUseCaseImpl @Inject constructor(
    private val repo: BookmarksRepository
): AddBathroomToBookmarksUseCase {
    override suspend fun execute(details: BathroomDetails) {
        repo.bookmarkBathroom(details)
    }
}