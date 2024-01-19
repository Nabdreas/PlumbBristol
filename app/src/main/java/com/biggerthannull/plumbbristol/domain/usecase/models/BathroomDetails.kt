package com.biggerthannull.plumbbristol.domain.usecase.models

data class BathroomDetails(
    val id: String,
    val title: String,
    val description: String,
    val price: String,
    val duration: String,
    val gallery: List<String>,
    val isBookmarked: Boolean
)
