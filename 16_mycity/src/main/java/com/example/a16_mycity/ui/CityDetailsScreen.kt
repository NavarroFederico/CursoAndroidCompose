package com.example.a16_mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a16_mycity.R
import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation
import com.example.a16_mycity.ui.theme.CursoAndroidComposeTheme

@Composable
fun CityDetailsScreen(
    cityUiState: CityUiState,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false,
) {
    BackHandler {
        onBackPressed()
    }
    Box() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                .padding(top = dimensionResource(id = R.dimen.detail_card_list_padding_top))
        ) {
            item {
                if (isFullScreen) {
                    CityDetailsScreenTopBar(
                        onBackPressed = onBackPressed,
                        cityUiState = cityUiState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = dimensionResource(id = R.dimen.detail_topbar_padding_bottom))
                    )
                }
                CityRecommendationsDetailsCard(
                    recommendation = cityUiState.currentSelectedRecommendation,
                    categoryType = cityUiState.currentRecommendationType,
                    modifier = if (isFullScreen) {
                        Modifier.padding(horizontal = dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal))
                    } else {
                        Modifier.padding(end = dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal))
                    }
                )
            }
        }
    }


}

@Composable
private fun CityDetailsScreenTopBar(
    onBackPressed: () -> Unit,
    cityUiState: CityUiState,
    modifier: Modifier = Modifier,
) {

}

@Composable
private fun CityRecommendationsDetailsCard(
    recommendation: Recommendation,
    categoryType: CategoryType,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        if (recommendation.imageResourceId != null) {
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.detail_card_inner_padding))
        ) {
            Text(
                text = stringResource(id = recommendation.titleResourceId),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.detail_card_inner_padding))

            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CityRecommendationsDetailsCardPreview() {
    CursoAndroidComposeTheme {
        Surface {
            CityRecommendationsDetailsCard(
                recommendation = LocalRecommendationsDataProvider.getRecommendationData()[0],
                categoryType = LocalRecommendationsDataProvider.getRecommendationData()[0].category,
            )
        }
    }
}