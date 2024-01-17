package com.biggerthannull.plumbbristol.domain.repository

import com.biggerthannull.plumbbristol.domain.usecase.models.Employee

interface TeamRepository {
    suspend fun getTeam(): List<Employee>
}