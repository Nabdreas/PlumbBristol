package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.DiscoveredBathroomsDTO

interface DiscoverDataSource {
    suspend fun discoverBathrooms(): Result<List<DiscoveredBathroomsDTO>>
}