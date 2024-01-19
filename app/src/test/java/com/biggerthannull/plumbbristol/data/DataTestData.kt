package com.biggerthannull.plumbbristol.data

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.biggerthannull.plumbbristol.data.datasource.model.DiscoveredBathroomsDTO
import com.biggerthannull.plumbbristol.data.datasource.model.EmployeeDTO
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee

object DataTestData {
    val employeeDTO = EmployeeDTO(
        name = "Bob",
        age = "6",
        yearsOfExperience = "lifetime",
        profileImage = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg",
        position = "Builder"
    )

    val employee = Employee(
        name = "Bob",
        age = "6",
        experience = "lifetime",
        photoUrl = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg",
        position = "Builder"
    )

    val bathroomDTO = BathroomDTO(
        id = "id",
        title = "Top bathroom",
        description = "incredible handy works",
        price = "£1500",
        duration = "7 days",
        images = listOf("https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg")
    )

    val bathroomOverview = BathroomOverview(
        id = "id",
        title = "Top bathroom",
        coverImage = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg"
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

    val discoveredBathroomsDTO = DiscoveredBathroomsDTO(
        imageUrl = "https://kitchensplusbathrooms.co.uk/wp-content/uploads/2023/05/USED-KB_11.22-31-resized.webp"
    )
}