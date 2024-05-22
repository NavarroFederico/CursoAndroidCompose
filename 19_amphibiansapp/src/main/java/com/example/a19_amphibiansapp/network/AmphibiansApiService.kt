package com.example.a19_amphibiansapp.network

import com.example.a19_amphibiansapp.model.Amphibian
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>

}