package com.example.a16_mycity.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Castle
import androidx.compose.material.icons.outlined.NightShelter
import androidx.compose.material.icons.outlined.Park
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.a16_mycity.R
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
    val navigationItemContentList = listOf(
        NavigationItemContent(
            categoryType = CategoryType.Parks,
            icon = Icons.Outlined.Park,
            text = stringResource(id = R.string.tab_parks)

        ),
        NavigationItemContent(
            categoryType = CategoryType.GovernmentOffices,
            icon = Icons.Outlined.Castle,
            text = stringResource(id = R.string.tab_governmentOffices)
        ),
        NavigationItemContent(
            categoryType = CategoryType.Housing,
            icon = Icons.Outlined.NightShelter,
            text = stringResource(id = R.string.tab_housing)
        ),
        NavigationItemContent(
            categoryType = CategoryType.ShoppingCenters,
            icon = Icons.Outlined.Storefront,
            text = stringResource(id = R.string.tab_shoppingCenters)
        )
    )
}

@Composable
private fun CityAppContent(
    navigationType: CityNavigationType,
    contentType: CityContentType,
    cityUiState: CityUiState,
    onTabPressed: (CategoryType) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {


}

private data class NavigationItemContent(
    val categoryType: CategoryType,
    val icon: ImageVector,
    val text: String
)