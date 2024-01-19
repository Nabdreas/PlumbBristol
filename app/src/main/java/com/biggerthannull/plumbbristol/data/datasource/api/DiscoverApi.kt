package com.biggerthannull.plumbbristol.data.datasource.api

import com.biggerthannull.plumbbristol.data.datasource.model.DiscoveredBathroomsDTO
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface DiscoverApi {
    @GET("services/rest/")
    suspend fun getImages(
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") apiKey: String,
        @Query("text") text: String = "bathroom ideas",
        @Query("tags") tags: String = "bathroomideas",
        @Query("content_types") contentType: Int = 0,
        @Query("format") format: String = "json",
        @Query("privacy_filter") privacyFilter: Int = 1,
        @Query("nojsoncallback") noJSONCallBack: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): Response<DiscoveredBathroomsDTO>
}