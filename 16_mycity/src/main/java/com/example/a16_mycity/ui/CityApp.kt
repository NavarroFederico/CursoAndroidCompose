package com.example.a16_mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation
import com.example.a16_mycity.ui.utils.CityContentType
import com.example.a16_mycity.ui.utils.CityNavigationType

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: CityNavigationType
    val contentType: CityContentType
    val viewModel: CityViewModel = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = CityNavigationType.BOTTOM_NAVIGATION
            contentType = CityContentType.LIST_ONLY

        }

        WindowWidthSizeClass.Medium -> {
            navigationType = CityNavigationType.NAVIGATION_RAIL
            contentType = CityContentType.LIST_ONLY

        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = CityNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = CityContentType.LIST_AND_DETAIL
        }

        else -> {
            navigationType = CityNavigationType.BOTTOM_NAVIGATION
            contentType = CityContentType.LIST_ONLY
        }
    }

    CityHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        cityUiState = cityUiState,
        onTabPressed = { recommendationType: CategoryType ->
            viewModel.updateCurrentRecommendation(categoryType = recommendationType)
            viewModel.resetHomeScreenStates()
        },
        onRecommendationPressed = { recommendation: Recommendation ->
            viewModel.updateDetailsScreenStates(recommendation = recommendation)
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}

