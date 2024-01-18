package com.biggerthannull.plumbbristol.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.biggerthannull.plumbbristol.data.database.room.dao.BookmarksDao
import com.biggerthannull.plumbbristol.data.database.room.entity.BathroomEntity
import com.biggerthannull.plumbbristol.data.database.room.utils.Converters

@Database(
    entities = [BathroomEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BookmarksDatabase : RoomDatabase() {
    abstract fun dao(): BookmarksDao
}