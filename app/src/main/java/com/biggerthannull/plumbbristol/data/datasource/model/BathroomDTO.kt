package com.biggerthannull.plumbbristol.data.datasource.model

data class BathroomDTO(
    val description: String? = null,
    val duration: String? = null,
    val images: List<String> = emptyList(),
    val price: String? = null,
    val title: String? = null
)
