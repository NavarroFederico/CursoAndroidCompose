package com.example.a16_mycity.ui

import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import com.example.a16_mycity.model.Recommendation

class CityUiState(
    val recommendationsList: List<Recommendation> = emptyList(),
    val currentRecommendation: Recommendation = LocalRecommendationsDataProvider.defaultRecommendation,
    val isShowingHomepage : Boolean = true
)
{
}