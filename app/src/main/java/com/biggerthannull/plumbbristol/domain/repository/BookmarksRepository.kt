package com.biggerthannull.plumbbristol.domain.repository

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import kotlinx.coroutines.flow.Flow

interface BookmarksRepository {
    suspend fun bookmarkBathroom(details: BathroomDetails)
    suspend fun observeBookmarkedBathrooms(): Flow<List<BathroomDetails>>
    suspend fun removeBookmarkedBathroom(id: String)
}