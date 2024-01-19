package com.biggerthannull.plumbbristol.data.repository

import android.util.Log
import com.biggerthannull.plumbbristol.data.datasource.BathroomsRemoteDataSource
import com.biggerthannull.plumbbristol.data.datasource.BathroomsLocalDataSource
import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BathroomsRepositoryImpl @Inject constructor(
    private val dataSource: BathroomsRemoteDataSource,
    private val localBookmarksDataSource: BathroomsLocalDataSource
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
                emptyList()
            }
        )
    }

    override suspend fun getBathroomDetails(bathroomId: String): BathroomDetailsResult {
        return withContext(Dispatchers.IO) {
            val isAdded = localBookmarksDataSource.isAdded(bathroomId)
            Log.d("BOOKMARKED is added:", isAdded.toString())
            dataSource.getBathroomDetails(bathroomId).fold(
                onSuccess = { details ->
                    val result = mapFromDTOToDomain(details, isAdded)
                    BathroomDetailsResult.Success(data = result)
                },
                onFailure = {
                    BathroomDetailsResult.Failed
                }
            )
        }
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