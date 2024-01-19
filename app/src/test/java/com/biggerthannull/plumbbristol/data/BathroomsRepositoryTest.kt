package com.biggerthannull.plumbbristol.data

import com.biggerthannull.plumbbristol.data.DataTestData.bathroomDTO
import com.biggerthannull.plumbbristol.data.DataTestData.bathroomDetails
import com.biggerthannull.plumbbristol.data.DataTestData.bathroomOverview
import com.biggerthannull.plumbbristol.data.DataTestData.discoveredBathroomsDTO
import com.biggerthannull.plumbbristol.data.datasource.BathroomsLocalDataSource
import com.biggerthannull.plumbbristol.data.datasource.BathroomsRemoteDataSource
import com.biggerthannull.plumbbristol.data.datasource.DiscoverDataSource
import com.biggerthannull.plumbbristol.data.repository.BathroomsRepositoryImpl
import com.biggerthannull.plumbbristol.domain.DomainTestData.discoveredBathrooms
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoverBathroomsResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BathroomsRepositoryTest {
    private val remoteDataSource: BathroomsRemoteDataSource = mockk()
    private val localDataSource: BathroomsLocalDataSource = mockk()
    private val discoverDataSource: DiscoverDataSource = mockk()
    private val sut: BathroomsRepository = BathroomsRepositoryImpl(
        remoteDataSource,
        localDataSource,
        discoverDataSource
    )

    private val bathroomId = "bathroomId"

    @Test
    fun `should get list of bathrooms`() = runTest {
        // Given
        coEvery { remoteDataSource.getBathrooms() } returns Result.success(
            listOf(bathroomDTO)
        )

        // When
        val result = sut.getBathrooms()

        // Then
        assertEquals(listOf(bathroomOverview), result)
    }

    @Test
    fun `should return empty list when failed to get bathrooms`() = runTest {
        // Given
        coEvery { remoteDataSource.getBathrooms() } returns Result.failure(Exception("failed"))

        // When
        val result = sut.getBathrooms()

        // Then
        assertEquals(emptyList<BathroomOverview>(), result)
    }

    @Test
    fun `should return bathroom details successfully`() = runTest {
        // Given
        coEvery { remoteDataSource.getBathroomDetails(bathroomId) } returns Result.success(
            bathroomDTO
        )
        coEvery { localDataSource.isAdded(bathroomId) } returns true

        // When
        val result = sut.getBathroomDetails(bathroomId)

        // Then
        assertTrue(result is BathroomDetailsResult.Success)
        assertEquals(bathroomDetails(true), (result as BathroomDetailsResult.Success).data)
    }

    @Test
    fun `should NOT return bathroom details successfully`() = runTest {
        // Given
        coEvery { remoteDataSource.getBathroomDetails(bathroomId) } returns Result.failure(
            Exception(
                "failed"
            )
        )
        coEvery { localDataSource.isAdded(bathroomId) } returns false

        // When
        val result = sut.getBathroomDetails(bathroomId)

        // Then
        assertTrue(result is BathroomDetailsResult.Failed)
    }

    @Test
    fun `should return a list of discovered bathrooms`() = runTest {
        // Given
        coEvery { discoverDataSource.discoverBathrooms() } returns Result.success(discoveredBathroomsDTO )

        // When
        val result = sut.discoverBathrooms()

        // Then
        assertTrue(result is DiscoverBathroomsResult.Success)
        assertEquals(
            listOf(discoveredBathrooms),
            (result as DiscoverBathroomsResult.Success).data
        )
    }
}