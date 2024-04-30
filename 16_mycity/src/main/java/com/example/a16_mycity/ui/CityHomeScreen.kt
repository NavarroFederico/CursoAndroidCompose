package com.example.a16_mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Castle
import androidx.compose.material.icons.outlined.NightShelter
import androidx.compose.material.icons.outlined.Park
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
    if (navigationType == CityNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        val navigationDrawerContentDescription = stringResource(id = R.string.navigation_drawer)
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(modifier = Modifier.width(dimensionResource(id = R.dimen.drawer_width))) {
                    NavigationDrawerContent(
                        selectedDestination = cityUiState.currentRecommendationType,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(id = R.dimen.drawer_padding_content)),
                    )
                }
            },
        ) {
            CityAppContent(
                navigationType = navigationType,
                contentType = contentType,
                cityUiState = cityUiState,
                onTabPressed = onTabPressed,
                onRecommendationPressed = onRecommendationPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    } else {
        if (cityUiState.isShowingHomepage) {
            CityAppContent(
                navigationType = navigationType,
                contentType = contentType,
                cityUiState = cityUiState,
                onTabPressed = onTabPressed,
                onRecommendationPressed = onRecommendationPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier,
            )
        } else {
            CityDetailsScreen(
                cityUiState = cityUiState,
                onBackPressed = onDetailScreenBackPressed,
                isFullScreen = true,
                modifier = modifier
            )
        }
    }
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
    Row(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == CityNavigationType.NAVIGATION_RAIL) {
            val navigationRailContentDescription = stringResource(id = R.string.navigation_rail)
            CityNavigationRail(
                currentTab = cityUiState.currentRecommendationType,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            if (contentType == CityContentType.LIST_AND_DETAIL) {
                CityListAndDetailContent(
                    cityUiState = cityUiState,
                    onItemCardPressed = onRecommendationPressed,
                    modifier = Modifier.weight(1f)
                )
            } else {
                CityListOnlyContent(
                    cityUiState = cityUiState,
                    onItemCardPressed = onRecommendationPressed,
                    modifier = Modifier.weight(1f)
                )
            }
            val bottomNavigationContentDescription = stringResource(id = R.string.navigation_bottom)
            AnimatedVisibility(visible = navigationType == CityNavigationType.BOTTOM_NAVIGATION) {
                CityBottomNavigationBar(
                    currentTab = cityUiState.currentRecommendationType,
                    onTabPressed = onTabPressed,
                    navigationItemContentList= navigationItemContentList,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }

}



@Composable
private fun CityNavigationRail(
    currentTab: CategoryType,
    onTabPressed: (CategoryType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier

) {
    NavigationRail(
        modifier = modifier
    ) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.categoryType,
                onClick = { onTabPressed(navItem.categoryType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                })
        }
    }
}
@Composable
private fun CityBottomNavigationBar(
    currentTab: CategoryType,
    onTabPressed: (CategoryType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
){
    NavigationBar(modifier= modifier){
        for(navItem in navigationItemContentList){
            NavigationBarItem(
                selected = currentTab == navItem.categoryType,
                onClick = {onTabPressed(navItem.categoryType)},
                icon = {
                    Icon(imageVector = navItem.icon,
                        contentDescription = navItem.text)
                }
            )
        }
    }
}
@Composable
private fun NavigationDrawerContent(
    selectedDestination: CategoryType,
    onTabPressed: (CategoryType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.profile_image_padding)),
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.categoryType,
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.drawer_padding_header))
                    )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedBadgeColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.categoryType) }
            )
        }
    }
}

@Composable
fun NavigationDrawerHeader(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CityLogo(modifier = Modifier.size(dimensionResource(id = R.dimen.reply_logo_size)))
    }
}


private data class NavigationItemContent(
    val categoryType: CategoryType,
    val icon: ImageVector,
    val text: String
)

