package com.example.a20_bookshelf.model

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
    val description: String,
    @SerialName("authors")
    val authors: List<String>,
    @SerialName("imageLinks")
    val imageLinks: ImageLinks,
)

@Serializable
data class ImageLinks(
    /* val smallThumbnail: String,*/
    val thumbnail: String,
    /*  val small: String,
      val medium: String,
      val large: String,
      val extraLarge: String*/
)
