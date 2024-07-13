package com.example.a20_bookshelf.data

import com.example.a20_bookshelf.model.BooksVolumesList
import com.example.a20_bookshelf.network.BooksApiService

interface BookshelfRepository {
    suspend fun getBooksVolumes(): BooksVolumesList

    suspend fun getResult(): String
}
/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class NetworkBooksRepository(
    private val booksApiService: BooksApiService
):
        BookshelfRepository{
    /** Retrieves list of book from underlying data source */
    override suspend fun getBooksVolumes(): BooksVolumesList = booksApiService.getBooksVolumes()
    override suspend fun getResult(): String = booksApiService.getResult()



}

