package com.biggerthannull.plumbbristol.data

import com.biggerthannull.plumbbristol.data.DataTestData.expectedPhotoJSONResponse
import com.biggerthannull.plumbbristol.data.datasource.DiscoverDataSource
import com.biggerthannull.plumbbristol.data.datasource.DiscoverDataSourceImpl
import com.biggerthannull.plumbbristol.data.datasource.api.DiscoverApi
import com.biggerthannull.plumbbristol.utils.FileUtil
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.EOFException
class DiscoverDataSourceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var sut: DiscoverDataSource
    private val validResponse =
        FileUtil.readFileWithoutNewLineFromResources("photosTestResponse.json")

    @BeforeEach
    fun before() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @AfterEach
    fun after() {
        mockWebServer.shutdown()
    }

    @Test
    fun `return valid response with an photo`() = runTest {
        // Given
        sut = DiscoverDataSourceImpl(buildApi())
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validResponse)
        )

        // When
        val result = sut.discoverBathrooms()

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedPhotoJSONResponse, result.getOrNull())
    }

    @Test
    fun `return an exception when backend JSON contract changed`() = runTest {
        // Given
        sut = DiscoverDataSourceImpl(buildApi())
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody("")
        )

        // When
        val result = sut.discoverBathrooms()

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is EOFException)
    }

    @Test
    fun `should result in failure when api fails`() = runTest {
        // Given
        sut = DiscoverDataSourceImpl(buildApi())
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(401)
                .setBody("")
        )

        // When
        val result = sut.discoverBathrooms()

        // Then
        assertTrue(result.isFailure)
        assertEquals("Whoops failed to get photos", result.exceptionOrNull()?.message)
    }

    private fun buildApi(): DiscoverApi {
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("photos/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DiscoverApi::class.java)
    }
}