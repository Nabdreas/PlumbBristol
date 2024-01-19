package com.biggerthannull.plumbbristol.data.repository

import com.biggerthannull.plumbbristol.data.datasource.BathroomsRemoteDataSource
import com.biggerthannull.plumbbristol.data.datasource.BathroomsLocalDataSource
import com.biggerthannull.plumbbristol.data.datasource.DiscoverDataSource
import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoveredBathrooms
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BathroomsRepositoryImpl @Inject constructor(
    private val dataSource: BathroomsRemoteDataSource,
    private val localBookmarksDataSource: BathroomsLocalDataSource,
    private val discoverDataSource: DiscoverDataSource
) : BathroomsRepository {
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
                // can add some sort of a logging here, Crashlytics/Timber etc
                emptyList()
            }
        )
    }

    override suspend fun getBathroomDetails(bathroomId: String): BathroomDetailsResult {
        return withContext(Dispatchers.IO) {
            val isAdded = localBookmarksDataSource.isAdded(bathroomId)
            dataSource.getBathroomDetails(bathroomId).fold(
                onSuccess = { details ->
                    val result = mapFromDTOToDomain(details, isAdded)
                    BathroomDetailsResult.Success(data = result)
                },
                onFailure = {
                    // can add some sort of a logging here, Crashlytics/Timber etc
                    BathroomDetailsResult.Failed
                }
            )
        }
    }

    override suspend fun discoverBathrooms(): DiscoverBathroomsResult {
        return discoverDataSource.discoverBathrooms().fold(
            onSuccess = { images ->
                val result = images.map { image ->
                    DiscoveredBathrooms(imageUrl = image.imageUrl)
                }
                DiscoverBathroomsResult.Success(data = result)
            },
            onFailure = {
                // can add some sort of a logging here, Crashlytics/Timber etc
                DiscoverBathroomsResult.Error
            }
        )
    }

    private fun mapFromDTOToDomain(dto: BathroomDTO, isAdded: Boolean): BathroomDetails {
        return BathroomDetails(
            id = dto.id.orEmpty(),
            title = dto.title.orEmpty(),
            description = dto.description.orEmpty(),
            price = dto.price.orEmpty(),
            duration = dto.duration.orEmpty(),
            gallery = dto.images,
            isBookmarked = isAdded
        )
    }
}