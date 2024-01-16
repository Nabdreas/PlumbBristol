package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import javax.inject.Inject

class BathroomsDataSourceImpl @Inject constructor(): BathroomsDataSource {
    override fun getBathrooms(): Result<List<BathroomDTO>> {
        return Result.success(emptyList())
    }
}