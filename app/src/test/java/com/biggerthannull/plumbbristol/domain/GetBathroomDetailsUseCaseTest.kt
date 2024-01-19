package com.biggerthannull.plumbbristol.domain

import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetailsResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GetBathroomDetailsUseCaseTest {

    private val repo: BathroomsRepository = mockk()
    private val sut: GetBathroomDetailsUseCase = GetBathroomDetailsUseCaseImpl(repo)

    @Test
    fun `should get bathroom details`() = runTest {
        coEvery { repo.getBathroomDetails("bathroomId") } returns
                BathroomDetailsResult.Success(DomainTestData.bathroomDetails(false))

        val result = sut.execute("bathroomId")

        assertTrue(result is BathroomDetailsResult.Success)
    }
}