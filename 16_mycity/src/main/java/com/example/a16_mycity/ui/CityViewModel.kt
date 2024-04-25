package com.example.a16_mycity.ui

import androidx.lifecycle.ViewModel
import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val recommendations: Map<CategoryType, List<Recommendation>> =
            LocalRecommendationsDataProvider.getRecommendationData().groupBy { it.category }

        _uiState.value =
            CityUiState(
                recommendationsList = recommendations,
                currentSelectedRecommendation = recommendations[CategoryType.Parks]?.get(0)
                    ?: LocalRecommendationsDataProvider.defaultRecommendation
            )
    }

    fun updateCurrentRecommendation(categoryType: CategoryType) {
        _uiState.update {
            it.copy(
                currentRecommendationType = categoryType
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = it.recommendationsList[it.currentRecommendationType]?.get(
                    0
                ) ?: LocalRecommendationsDataProvider.defaultRecommendation
            )
        }
    }

    fun updateDetailsScreenStates(recommendation: Recommendation){
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation,
                isShowingHomepage = false
            )
        }

    }
}