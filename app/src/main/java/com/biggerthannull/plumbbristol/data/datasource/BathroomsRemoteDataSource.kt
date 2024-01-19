package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO

interface BathroomsRemoteDataSource {
    suspend fun getBathrooms(): Result<List<BathroomDTO>>
    suspend fun getBathroomDetails(documentId: String): Result<BathroomDTO>
}