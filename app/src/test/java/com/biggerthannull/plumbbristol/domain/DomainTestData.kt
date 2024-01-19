package com.biggerthannull.plumbbristol.domain

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoveredBathrooms
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee

object DomainTestData {
    val employee = Employee(
        name = "Bob",
        age = "6",
        experience = "lifetime",
        photoUrl = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg",
        position = "Builder"
    )

    val newEmployee = Employee(
        name = "Dave",
        age = "18",
        experience = "0",
        position = "intern",
        photoUrl = ""
    )

    val bathroom = BathroomOverview(
        id = "id",
        title = "mega title",
        coverImage = "randomUrl"
    )

    fun bathroomDetails(isBookmarked: Boolean) = BathroomDetails(
        id = "id",
        title = "Top bathroom",
        description = "incredible handy works",
        price = "£1500",
        duration = "7 days",
        gallery = listOf("https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg"),
        isBookmarked = isBookmarked
    )

    val discoveredBathrooms = DiscoveredBathrooms(
        imageUrl = "https://kitchensplusbathrooms.co.uk/wp-content/uploads/2023/05/USED-KB_11.22-31-resized.webp"
    )
}