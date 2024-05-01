package com.example.a16_mycity.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.a16_mycity.R
import com.example.a16_mycity.data.LocalRecommendationsDataProvider
import com.example.a16_mycity.model.CategoryType
import com.example.a16_mycity.model.Recommendation
import com.example.a16_mycity.ui.theme.CursoAndroidComposeTheme


@Composable
fun CityListOnlyContent(
    cityUiState: CityUiState,
    onItemCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
) {

    val recommendations = cityUiState.currentCategoryRecommendations

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.recommendation_list_item_vertical_spacing)
        )
    ) {
        item {
            CityHomeTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.topbar_padding_vertical))
            )
        }
        items(recommendations, key = { recommendation -> recommendation.id }) { recommendation ->
            CityRecommendationListItem(
                recommendation = recommendation,
                selected = false,
                onCardClick = {
                    onItemCardPressed(recommendation)
                }
            )
        }
    }
}

@Composable
fun CityListAndDetailContent(
    cityUiState: CityUiState,
    onItemCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    val recommendations = cityUiState.currentCategoryRecommendations
    Row(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .weight(0.8f)
                .padding(
                    end = dimensionResource(R.dimen.list_and_detail_list_padding_end),
                    top = dimensionResource(R.dimen.list_and_detail_list_padding_top)
                ),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.recommendation_list_item_vertical_spacing))
        ) {
            items(
                recommendations,
                key = { recommendation -> recommendation.id }) { recommendation ->
                CityRecommendationListItem(
                    recommendation = recommendation,
                    selected = cityUiState.currentSelectedRecommendation.id == recommendation.id,
                    onCardClick = {
                        onItemCardPressed(recommendation)
                    },
                )
            }
        }
        val activity = LocalContext.current as Activity
        CityDetailsScreen(
            cityUiState = cityUiState,
            onBackPressed = { activity.finish() },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun CityRecommendationListItem(
    recommendation: Recommendation,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onCardClick
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.email_list_item_inner_padding))
        ) {

            Text(
                text = stringResource(recommendation.titleResourceId),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
            )
            Text(
                text = stringResource(recommendation.address),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3
            )
            Text(
                text = stringResource(recommendation.openingHours),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3
            )
        }
    }
}

@Composable
private fun CityHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CityLogo(
        )
    }
}

@Composable
fun CityLogo(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Municipalidad de",
                    style = MaterialTheme.typography.titleSmall,

                    )
                Text(
                    text = stringResource(id = R.string.app_name).uppercase(),
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.titleMedium,
                    color = color,
                )

            }
            Image(
                painter = painterResource(id = R.drawable.image_removebg_preview__2_),
                contentDescription = null,
                modifier = Modifier
            )

        }

    }

}


@Preview
@Composable
fun previewReplyHomeTopBar() {
    val recommendations: Map<CategoryType, List<Recommendation>> =
        LocalRecommendationsDataProvider.getRecommendationData().groupBy { it.category }


    val cityUiState = CityUiState(
        recommendationsList = recommendations,
        currentSelectedRecommendation = recommendations[CategoryType.Housing]?.get(0)
            ?: LocalRecommendationsDataProvider.defaultRecommendation
    )

    CursoAndroidComposeTheme {
        Surface {
            CityListOnlyContent(cityUiState = cityUiState, onItemCardPressed = {})

        }

    }
}