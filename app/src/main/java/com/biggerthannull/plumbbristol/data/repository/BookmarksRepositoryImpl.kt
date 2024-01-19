package com.biggerthannull.plumbbristol.data.repository

import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import com.biggerthannull.plumbbristol.data.datasource.BathroomsLocalDataSource
import com.biggerthannull.plumbbristol.domain.repository.BookmarksRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarksRepositoryImpl @Inject constructor(
    private val bathroomsLocalDataSource: BathroomsLocalDataSource
) : BookmarksRepository {
    override suspend fun bookmarkBathroom(details: BathroomDetails) {
        val bathroomEntity = BathroomEntity(
            id = details.id,
            description = details.description,
            duration = details.duration,
            images = details.gallery,
            price = details.price,
            title = details.title
        )
        bathroomsLocalDataSource.addBookmarkedBathroom(bathroomEntity)
    }

    override suspend fun observeBookmarkedBathrooms(): Flow<List<BathroomDetails>> {
        return bathroomsLocalDataSource.observeBookmarkedBathrooms().map { entity ->
            entity.map { bathroom ->
                BathroomDetails(
                    id = bathroom.id,
                    description = bathroom.description,
                    duration = bathroom.duration,
                    gallery = bathroom.images,
                    price = bathroom.price,
                    title = bathroom.title,
                    isBookmarked = true
                )
            }
        }
    }

    override suspend fun removeBookmarkedBathroom(id: String) {
        bathroomsLocalDataSource.removeBookmarkedBathroom(id)
    }
}