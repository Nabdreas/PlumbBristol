package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import kotlinx.coroutines.flow.Flow

interface BathroomsLocalDataSource {

    suspend fun addBookmarkedBathroom(data: BathroomEntity)
    suspend fun removeBookmarkedBathroom(id: String)

    suspend fun observeBookmarkedBathrooms(): Flow<List<BathroomEntity>>

    suspend fun isAdded(id: String): Boolean
}