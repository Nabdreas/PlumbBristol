package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.EmployeeDTO
import com.biggerthannull.plumbbristol.data.di.NamedParams.TEAM
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class TeamDataSourceImpl @Inject constructor(
    @Named(TEAM) private val teamsCollection: CollectionReference
) : TeamDataSource {
    override suspend fun getTeam(): Result<List<EmployeeDTO>> {
        return try {
            val snapshot = teamsCollection.get().await()
            val mappedDTO = snapshot.map { document ->
                document.toObject(EmployeeDTO::class.java)
            }
            Result.success(mappedDTO)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}