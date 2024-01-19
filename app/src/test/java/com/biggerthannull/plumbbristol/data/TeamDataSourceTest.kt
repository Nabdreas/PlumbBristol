package com.biggerthannull.plumbbristol.data

import com.biggerthannull.plumbbristol.data.datasource.TeamDataSource
import com.biggerthannull.plumbbristol.data.datasource.TeamDataSourceImpl
import com.google.firebase.firestore.CollectionReference
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Ignore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

@Ignore("look up how to mock firestore response")
class TeamDataSourceTest {

    private val teamsCollection: CollectionReference = mockk()
    private val sut: TeamDataSource = TeamDataSourceImpl(teamsCollection)

    fun `should return valid list of employees`() = runTest {
        // Given

        // When
        val result = sut.getTeam()

        // Then
        assertEquals(listOf(DataTestData.employeeDTO), result)
    }

    fun `should NOT return valid list of employees`() = runTest {
        // Given

        // When
        val result = sut.getTeam()

        // Then
        assertTrue(result.isFailure)
    }

}