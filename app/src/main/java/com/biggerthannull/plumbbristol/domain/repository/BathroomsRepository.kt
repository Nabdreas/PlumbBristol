package com.biggerthannull.plumbbristol.domain.repository

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult

interface BathroomsRepository {
    suspend fun getBathrooms(): List<BathroomOverview>
    suspend fun getBathroomDetails(bathroomId: String): BathroomDetailsResult
    suspend fun discoverBathrooms(): DiscoverBathroomsResult
}