package com.example.a16_mycity.ui

import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation

data class CityUiState(
    val recommendationsList: Map<CategoryType, List<Recommendation>> = emptyMap(),
    val currentRecommendationType: CategoryType = CategoryType.Parks,
    val currentSelectedRecommendation: Recommendation = LocalRecommendationsDataProvider.defaultRecommendation,
    val isShowingHomepage: Boolean = true
)
{
    val currentCategoryRecommendations: List<Recommendation> by lazy { recommendationsList[currentRecommendationType]!! }
}