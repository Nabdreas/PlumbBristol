package com.biggerthannull.plumbbristol.data.database.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarksDao {
    @Upsert
    suspend fun upsertBookmarkedBathroom(data: BathroomEntity)

    @Query("SELECT * from bookmarkedBathrooms")
    fun getBookmarkedBathrooms(): Flow<List<BathroomEntity>>
}
