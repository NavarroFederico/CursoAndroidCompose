package com.example.a20_bookshelf.network

import com.example.a20_bookshelf.model.Book
import com.example.a20_bookshelf.model.BooksVolumesList
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getBooksVolumes(): BooksVolumesList

    @GET("volumes/{volumeId}")
    suspend fun getInfoAboutBook(@Path("volumeId") volumeId: String): Book

    @GET("volumes?q=jazz+history")
    suspend fun getResult(): String
}


