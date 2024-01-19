package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.database.room.dao.BookmarksDao
import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BathroomsLocalDataSourceImpl @Inject constructor(
    private val dao: BookmarksDao
): BathroomsLocalDataSource {
    override suspend fun addBookmarkedBathroom(data: BathroomEntity) {
        dao.upsertBookmarkedBathroom(data)
    }

    override suspend fun removeBookmarkedBathroom(id: String) {
        dao.deleteBookmarkedBathroom(id)
    }

    override suspend fun observeBookmarkedBathrooms(): Flow<List<BathroomEntity>> {
        return dao.getBookmarkedBathrooms()
    }

    override suspend fun isAdded(id: String): Boolean {
        return dao.isAdded(id)
    }
}