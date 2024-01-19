package com.biggerthannull.plumbbristol.data.datasource.model

import androidx.annotation.Keep

@Keep
data class DiscoveredBathroomsDTO(
    val photos: PhotosDTO
)
@Keep
data class PhotosDTO(
    val photo: List<PhotoDTO>
)
@Keep
data class PhotoDTO(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)