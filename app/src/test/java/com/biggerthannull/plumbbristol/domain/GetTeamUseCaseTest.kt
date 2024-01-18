package com.biggerthannull.plumbbristol.domain

import com.biggerthannull.plumbbristol.domain.repository.TeamRepository
import com.biggerthannull.plumbbristol.domain.usecase.GetTeamUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetTeamUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetTeamUseCaseTest {

    private val repo: TeamRepository = mockk()
    private val sut: GetTeamUseCase = GetTeamUseCaseImpl(
        repo
    )

    @Test
    fun `that we receive list of employees`() = runTest {
        // Given
        coEvery { repo.getTeam() } returns listOf(DomainTestData.employee)

        // When
        val result = sut.execute()

        // Then
        assertEquals(listOf(DomainTestData.employee), result)
    }

    @Test
    fun `should only return employees with a photo`() = runTest {
        // Given
        coEvery { repo.getTeam() } returns listOf(
            DomainTestData.employee, DomainTestData.newEmployee
        )

        // When
        val result = sut.execute()

        // Then
        assertEquals(listOf(DomainTestData.employee), result)
    }
}