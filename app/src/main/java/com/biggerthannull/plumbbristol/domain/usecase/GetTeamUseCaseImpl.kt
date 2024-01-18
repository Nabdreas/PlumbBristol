package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.repository.TeamRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import javax.inject.Inject

class GetTeamUseCaseImpl @Inject constructor(
    private val repo: TeamRepository
): GetTeamUseCase {
    override suspend fun execute(): List<Employee> {
        return repo.getTeam().filter {
            it.photoUrl.isNotEmpty()
        }
    }
}