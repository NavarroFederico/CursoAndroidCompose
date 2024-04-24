package com.example.a16_mycity.ui

import androidx.lifecycle.ViewModel
import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value =
            CityUiState(
                recommendationsList = LocalRecommendationsDataProvider.getRecommendationData(),
                currentRecommendation = LocalRecommendationsDataProvider.getRecommendationData().getOrElse(0){
                    LocalRecommendationsDataProvider.defaultRecommendation
                }
            )
    }

}