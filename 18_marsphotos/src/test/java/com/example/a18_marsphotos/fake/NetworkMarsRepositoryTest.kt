package com.example.a18_marsphotos.fake

import com.example.a18_marsphotos.data.NetworkMarsPhotosRepository
import org.junit.Assert.assertEquals
import org.junit.Test

import kotlinx.coroutines.test.runTest

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals (FakeDataSource.photosList, repository.getMarsPhotos())
    }
}