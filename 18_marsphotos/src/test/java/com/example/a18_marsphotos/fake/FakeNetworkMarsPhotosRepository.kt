package com.example.a18_marsphotos.fake

import com.example.a18_marsphotos.data.MarsPhotosRepository
import com.example.a18_marsphotos.network.MarsPhoto

class FakeNetworkMarsPhotosRepository: MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}