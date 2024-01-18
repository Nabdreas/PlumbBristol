package com.biggerthannull.plumbbristol.data

import com.biggerthannull.plumbbristol.data.datasource.TeamDataSource
import com.biggerthannull.plumbbristol.data.repository.TeamRepositoryImpl
import com.biggerthannull.plumbbristol.domain.repository.TeamRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TeamRepositoryTest {
    private val dataSource: TeamDataSource = mockk()
    private val sut: TeamRepository = TeamRepositoryImpl(dataSource)
    @Test
    fun `should return list of employees`() = runTest {
        // Given
        coEvery { dataSource.getTeam() } returns Result.success(
            listOf(DataTestData.employeeDTO)
        )

        // When
        val result = sut.getTeam()

        // Then
        assertEquals(listOf(DataTestData.employee), result)
    }

    @Test
    fun `returns empty list when backend error occurs`() = runTest {
        // Given
        coEvery { dataSource.getTeam() } returns Result.failure(Exception("failed"))

        // When
        val result = sut.getTeam()

        // Then
        assertEquals(emptyList<Employee>(), result)
    }
}