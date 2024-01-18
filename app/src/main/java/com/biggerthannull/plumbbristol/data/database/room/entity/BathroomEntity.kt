package com.biggerthannull.plumbbristol.data.database.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarkedBathrooms")
data class BathroomEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val description: String,
    val duration: String,
    val images: List<String>,
    val price: String,
    val title: String
)
