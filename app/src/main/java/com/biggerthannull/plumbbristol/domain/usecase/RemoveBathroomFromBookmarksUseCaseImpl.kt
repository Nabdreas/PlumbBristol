package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.BookmarksRepository
import javax.inject.Inject

class RemoveBathroomFromBookmarksUseCaseImpl @Inject constructor(
    private val repo: BookmarksRepository
): RemoveBathroomFromBookmarksUseCase {
    override suspend fun execute(id: String) {
        repo.removeBookmarkedBathroom(id)
    }
}