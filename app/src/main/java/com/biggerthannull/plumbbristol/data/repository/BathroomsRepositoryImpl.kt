package com.biggerthannull.plumbbristol.data.repository

import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSource
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import javax.inject.Inject

class BathroomsRepositoryImpl @Inject constructor(
    private val dataSource: BathroomsDataSource
): BathroomsRepository {
    override suspend fun getBathrooms(): List<BathroomOverview> {
        return dataSource.getBathrooms().fold(
            onSuccess = { bathrooms ->
                bathrooms.map { bathroom ->
                    BathroomOverview(
                        id = bathroom.id.orEmpty(),
                        title = bathroom.title.orEmpty(),
                        coverImage = bathroom.images.first()
                    )
                }
            },
            onFailure = {
                emptyList()
            }
        )
    }

    override fun getBathroom(): BathroomDetails {
        TODO("Not yet implemented")
    }
}