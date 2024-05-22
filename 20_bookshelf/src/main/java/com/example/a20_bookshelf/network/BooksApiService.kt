package com.example.a20_bookshelf.network

import com.example.a20_bookshelf.model.Book
import retrofit2.http.GET

interface BooksApiService {
@GET("books")
suspend fun getBooks(): List<Book>
}
