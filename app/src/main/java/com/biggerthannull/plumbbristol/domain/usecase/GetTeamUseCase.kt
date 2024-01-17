package com.biggerthannull.plumbbristol.domain.usecase

import com.biggerthannull.plumbbristol.domain.usecase.models.Employee

interface GetTeamUseCase {
    suspend fun execute(): List<Employee>
}