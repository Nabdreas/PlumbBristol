package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import kotlinx.coroutines.flow.Flow

interface LocalBathroomsDataSource {

    suspend fun addBookmarkedBathroom(data: BathroomEntity)

    suspend fun observeBookmarkedBathrooms(): Flow<List<BathroomEntity>>
}