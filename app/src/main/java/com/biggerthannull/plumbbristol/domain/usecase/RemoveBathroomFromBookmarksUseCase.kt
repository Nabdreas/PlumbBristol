package com.biggerthannull.plumbbristol.domain.usecase

interface RemoveBathroomFromBookmarksUseCase {
    suspend fun execute(id: String)
}