package com.example.a20_bookshelf.data

import com.example.a20_bookshelf.model.Book
import com.example.a20_bookshelf.network.BooksApiService

interface BookshelfRepository {
suspend fun getBooks(): List<Book>
}
/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class NetworkBooksRepository(
    private val booksApiService: BooksApiService
):
        BookshelfRepository{
    /** Retrieves list of amphibians from underlying data source */
    override suspend fun getBooks(): List<Book> = booksApiService.getBooks()


}

