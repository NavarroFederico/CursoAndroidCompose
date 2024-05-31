package com.example.a20_bookshelf.model

import com.example.a20_bookshelf.data.util.toHttps
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String = "",
    @SerialName("authors")
    val authors: List<String>,
    @SerialName("imageLinks")
    val imageLinks: ImageLinks,
)

@Serializable
data class ImageLinks(
    @SerialName("thumbnail")
    private val _thumbnail: String
) {
    val thumbnail: String
        get() = (_thumbnail ?: "").toHttps()
}
