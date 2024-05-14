package com.example.a18_marsphotos.fake

import com.example.a18_marsphotos.data.NetworkMarsPhotosRepository
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
    }
}