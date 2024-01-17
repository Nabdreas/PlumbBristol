package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.BathroomDTO
import com.biggerthannull.plumbbristol.data.di.NamedParams.BATHROOMS
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class BathroomsDataSourceImpl @Inject constructor(
    @Named(BATHROOMS) private val collection: CollectionReference
) : BathroomsDataSource {
    override suspend fun getBathrooms(): Result<List<BathroomDTO>> {
        return try {
            val snapshot = collection.get().await()
            val result = parseBathroomsSnapshotToDTO(snapshot)
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getBathroomDetails(documentId: String): Result<BathroomDTO> {
        return try {
            val snapshot = collection.document(documentId).get().await()
            val result = snapshot.toObject(BathroomDTO::class.java)
            if (result == null) {
                Result.failure(Exception("Something failed"))
            } else {
                Result.success(result)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun parseBathroomsSnapshotToDTO(snapshot: QuerySnapshot): List<BathroomDTO> {
        return snapshot.map { queryDocumentSnapshot ->
            val mapped = queryDocumentSnapshot.toObject(BathroomDTO::class.java)
            mapped.copy(
                id = queryDocumentSnapshot.id
            )
        }
    }
}