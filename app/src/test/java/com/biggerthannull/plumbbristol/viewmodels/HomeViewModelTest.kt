package com.biggerthannull.plumbbristol.viewmodels

import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCase
import com.biggerthannull.plumbbristol.ui.views.viewmodels.HomeViewModel
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.HomeScreenUIState
import com.biggerthannull.plumbbristol.viewmodels.ViewTestData.bathroomsOverview
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private val useCase: GetBathroomsUseCase = mockk()
    private lateinit var sut: HomeViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterEach
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should return list of completed bathrooms`() = runTest {
        // Given
        coEvery { useCase.execute() } returns listOf(bathroomsOverview)

        // When
        sut = HomeViewModel(useCase)

        // Then
        assertEquals(
            HomeScreenUIState(bathrooms = listOf(bathroomsOverview)),
            sut.uiState.value
        )
    }
}