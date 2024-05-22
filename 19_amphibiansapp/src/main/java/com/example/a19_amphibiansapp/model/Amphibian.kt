package com.example.a19_amphibiansapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Data class that defines an amphibian which includes a name, type, description, and image URL.
 */
@Serializable
data class Amphibian(
    val name: String,
    val description: String,
    val type: String,
    @SerialName("img_src")
    val imgSrc: String,
)