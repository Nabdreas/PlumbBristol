package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO

interface BathroomsDataSource {
    suspend fun getBathrooms(): Result<List<BathroomDTO>>
}