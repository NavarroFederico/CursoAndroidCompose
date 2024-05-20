package com.example.a19_amphibiansapp.data

import com.example.a19_amphibiansapp.network.Amphibian
import com.example.a19_amphibiansapp.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>


}

class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) :
    AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}


