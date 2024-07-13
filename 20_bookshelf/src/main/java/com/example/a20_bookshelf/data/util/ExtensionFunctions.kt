package com.example.a20_bookshelf.data.util

fun String.toHttps(): String {
    return this.replace("http", "https")
}