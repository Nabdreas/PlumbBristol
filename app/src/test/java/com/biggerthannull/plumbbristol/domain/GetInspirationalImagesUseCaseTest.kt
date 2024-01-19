package com.biggerthannull.plumbbristol.domain

import com.biggerthannull.plumbbristol.domain.DomainTestData.discoveredBathrooms
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.GetInspirationalImagesUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetInspirationalImagesUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GetInspirationalImagesUseCaseTest {

    private val repo: BathroomsRepository = mockk()
    private val sut: GetInspirationalImagesUseCase = GetInspirationalImagesUseCaseImpl(repo)

    @Test
    fun `should return discovered bathrooms result`() = runTest {
        // Given
        coEvery { repo.discoverBathrooms() } returns DiscoverBathroomsResult.Success(
            listOf(discoveredBathrooms)
        )

        // When
        val result = sut.execute()

        // Then
        assertTrue(result is DiscoverBathroomsResult.Success)
        assertEquals(listOf(discoveredBathrooms), (result as DiscoverBathroomsResult.Success).data)
    }

    @Test
    fun `should NOT return discovered bathrooms result`() = runTest {
        // Given
        coEvery { repo.discoverBathrooms() } returns DiscoverBathroomsResult.Error

        // When
        val result = sut.execute()

        // Then
        assertTrue(result is DiscoverBathroomsResult.Error)
    }
}