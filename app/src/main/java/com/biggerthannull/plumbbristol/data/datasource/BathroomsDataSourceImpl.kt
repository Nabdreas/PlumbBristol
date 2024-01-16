package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class BathroomsDataSourceImpl @Inject constructor(
    @Named("BATHROOMS")private val collection: CollectionReference
): BathroomsDataSource {
    override suspend fun getBathrooms(): Result<List<BathroomDTO>> {
        return try {
            val snapshot = collection.get().await()
            val result = parseToDTO(snapshot)
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun parseToDTO(snapshot: QuerySnapshot): List<BathroomDTO> {
        return snapshot.map {queryDocumentSnapshot ->
            queryDocumentSnapshot.toObject(BathroomDTO::class.java)
        }
    }
}