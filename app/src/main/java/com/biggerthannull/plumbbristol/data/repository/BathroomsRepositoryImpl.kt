package com.biggerthannull.plumbbristol.data.repository

import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSource
import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
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

    override suspend fun getBathroomDetails(bathroomId: String): BathroomDetailsResult {
        return dataSource.getBathroomDetails(bathroomId).fold(
            onSuccess = { details ->
                val result = mapFromDTOToDomain(details)
                BathroomDetailsResult.Success(data = result)
            },
            onFailure = {
                BathroomDetailsResult.Failed
            }
        )
    }

    private fun mapFromDTOToDomain(dto: BathroomDTO): BathroomDetails {
        return BathroomDetails(
            id = dto.id.orEmpty(),
            title = dto.title.orEmpty(),
            description = dto.description.orEmpty(),
            price = dto.price.orEmpty(),
            duration = dto.duration.orEmpty(),
            gallery = dto.images,
        )
    }
}