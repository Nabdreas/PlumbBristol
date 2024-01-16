package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO

interface BathroomsDataSource {
    fun getBathrooms(): Result<List<BathroomDTO>>
}