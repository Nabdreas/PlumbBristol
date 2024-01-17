package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.EmployeeDTO

interface TeamDataSource {
    suspend fun getTeam(): Result<List<EmployeeDTO>>
}