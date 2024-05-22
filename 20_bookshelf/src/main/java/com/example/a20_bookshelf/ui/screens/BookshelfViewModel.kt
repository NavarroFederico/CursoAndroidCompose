package com.example.a20_bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a20_bookshelf.BookshelfApplication
import com.example.a20_bookshelf.data.BookshelfRepository
import com.example.a20_bookshelf.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface BookshelfUiState {
    data class Success(val bookshelf: List<Book>) : BookshelfUiState
    data object Error : BookshelfUiState
    data object Loading : BookshelfUiState

}
/**
 * ViewModel containing the app data and method to retrieve the data
 */
class BookshelfViewModel(private val bookshelfRepository: BookshelfRepository): ViewModel() {
    var bookshelfUiState:  BookshelfUiState by mutableStateOf( BookshelfUiState.Loading)
        private set

    init {
        getBookshelves()
    }

    fun getBookshelves() {
        viewModelScope.launch {
            bookshelfUiState=
                try {
                    BookshelfUiState.Success(bookshelfRepository.getBooks())
                }
                catch (e: IOException) {
                    BookshelfUiState.Error
                } catch (e: HttpException) {
                    BookshelfUiState.Error
                }
        }
    }
    /**
     * Factory for [AmphibiansViewModel] that takes [AmphibiansRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.booksRepository
                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }
}
