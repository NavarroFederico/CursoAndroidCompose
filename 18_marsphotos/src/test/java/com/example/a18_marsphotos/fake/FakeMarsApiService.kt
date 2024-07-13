package com.example.a18_marsphotos.fake

import com.example.a18_marsphotos.network.MarsApiService
import com.example.a18_marsphotos.network.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}