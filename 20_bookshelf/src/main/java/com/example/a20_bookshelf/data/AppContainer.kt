package com.example.a20_bookshelf.data

import com.example.a20_bookshelf.network.BooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val booksRepository: BookshelfRepository
}
/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/v1/"

    private val json: Json = Json {
        ignoreUnknownKeys = true
    }
    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Use the Retrofit builder to build a string using ScalarConverter that supports strings and other primitive types.
     * Retrofit fetch a JSON response from the web service and return it as a String
     * add import retrofit2.converter.scalars.ScalarsConverterFactory and dependency
     * // Retrofit with Scalar Converter
     * implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
     */
    /* private val retrofit = Retrofit.Builder()
        // Add converter for handling simple data types (strings, integers, etc.)
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(baseUrl)
        .build()*/

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
    /**
     * DI implementation for Amphibians repository
     */
    override val booksRepository: BookshelfRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }

}