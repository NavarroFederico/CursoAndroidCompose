package com.example.a19_amphibiansapp.data

import com.example.a19_amphibiansapp.model.Amphibian
import com.example.a19_amphibiansapp.network.AmphibiansApiService
/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>


}
/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) :
    AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}


