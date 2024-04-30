package com.example.a16_mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.dimensionResource
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
private fun CityHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CityLogo(
            modifier = Modifier
                .size(dimensionResource(R.dimen.topbar_logo_size))
                .padding(start = dimensionResource(R.dimen.topbar_logo_padding_start))
        )
    }
}

@Composable
fun CityLogo(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = stringResource(id = R.string.app_name).uppercase(),
        fontFamily = FontFamily.Monospace,
    )

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


@Preview
@Composable
fun previewReplyHomeTopBar() {
    val recommendations: Map<CategoryType, List<Recommendation>> =
        LocalRecommendationsDataProvider.getRecommendationData().groupBy { it.category }


        val cityUiState= CityUiState(
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