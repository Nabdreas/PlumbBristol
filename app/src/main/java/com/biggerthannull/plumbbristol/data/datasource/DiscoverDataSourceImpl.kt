package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.BuildConfig
import com.biggerthannull.plumbbristol.data.datasource.api.DiscoverApi
import com.biggerthannull.plumbbristol.data.datasource.model.DiscoveredBathroomsDTO
import javax.inject.Inject

class DiscoverDataSourceImpl @Inject constructor(
    private val discoverApi: DiscoverApi
) : DiscoverDataSource {
    override suspend fun discoverBathrooms(): Result<DiscoveredBathroomsDTO> {
        return try {
            val response = discoverApi.getImages(apiKey = BuildConfig.FLICKR_API_KEY)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(body)
            } else {
                Result.failure(Exception("Whoops failed to get photos"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}