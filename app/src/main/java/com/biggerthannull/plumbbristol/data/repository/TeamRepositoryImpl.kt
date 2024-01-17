package com.biggerthannull.plumbbristol.data.repository

import com.biggerthannull.plumbbristol.data.datasource.TeamDataSource
import com.biggerthannull.plumbbristol.domain.repository.TeamRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamDataSource: TeamDataSource
) : TeamRepository {
    override suspend fun getTeam(): List<Employee> {
        return teamDataSource.getTeam().fold(
            onSuccess = { team ->
                team.map { employee ->
                    Employee(
                        name = employee.name.orEmpty(),
                        age = employee.age.orEmpty(),
                        experience = employee.yearsOfExperience.orEmpty(),
                        photoUrl = employee.profileImage.orEmpty(),
                        position = employee.position.orEmpty()
                    )
                }
            },
            onFailure = {
                emptyList()
            }
        )
    }
}