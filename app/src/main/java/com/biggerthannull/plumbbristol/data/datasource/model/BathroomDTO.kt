package com.biggerthannull.plumbbristol.data.datasource.model

data class BathroomDTO(
    val id: String? = null,
    val description: String? = null,
    val duration: String? = null,
    val images: List<String> = emptyList(),
    val price: String? = null,
    val title: String? = null
)
