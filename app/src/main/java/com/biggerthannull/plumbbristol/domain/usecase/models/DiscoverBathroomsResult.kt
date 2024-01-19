package com.biggerthannull.plumbbristol.domain.usecase.models

sealed class DiscoverBathroomsResult {
    data object Error: DiscoverBathroomsResult()
    class Success(val data: List<DiscoveredBathrooms>): DiscoverBathroomsResult()
}