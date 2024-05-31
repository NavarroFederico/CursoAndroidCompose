package com.example.a20_bookshelf.model

import com.example.a20_bookshelf.data.util.toHttps
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksVolumesList(
    val kind: String,
    @SerialName("items")
    val books: List<Book>,
    @SerialName("totalItems")
    val totalItems: Int
) {
    fun booksToHttpsList(): List<String> {
        val listUrl = mutableListOf<String>()
        books.forEach {
            listUrl.add(it.volumeInfo.imageLinks.thumbnail.toHttps())
        }
        return listUrl
    }
}
