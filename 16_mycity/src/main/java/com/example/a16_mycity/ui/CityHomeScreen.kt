package com.example.a16_mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation
import com.example.a16_mycity.ui.utils.CityContentType
import com.example.a16_mycity.ui.utils.CityNavigationType

@Composable
fun CityHomeScreen(
    navigationType: CityNavigationType,
    contentType: CityContentType,
    cityUiState: CityUiState,
    onTabPressed: (CategoryType) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier
) {
    TODO("Not yet implemented")
}
