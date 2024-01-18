package com.biggerthannull.plumbbristol.domain

import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetBathroomsUseCaseTest {

    private val repo: BathroomsRepository = mockk()
    private val sut: GetBathroomsUseCase = GetBathroomsUseCaseImpl(repo)

    @Test
    fun `should return list of completed bathrooms`() = runTest {
        // Given
        coEvery { repo.getBathrooms() } returns listOf(DomainTestData.bathroom)

        // When
        val result = sut.execute()

        // Then
        assertEquals(listOf(DomainTestData.bathroom), result)
    }
}