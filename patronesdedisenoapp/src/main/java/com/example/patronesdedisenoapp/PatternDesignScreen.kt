package com.example.patronesdedisenoapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patronesdedisenoapp.ui.theme.PatternDesignAppTheme
import com.example.patronesdedisenoapp.model.PatternDesign
import com.example.patronesdedisenoapp.model.PatternType
import com.example.patronesdedisenoapp.model.PatternsDesignRepository
import com.example.patronesdedisenoapp.ui.theme.MontserratAlternates
import com.example.patronesdedisenoapp.ui.util.customSpanStyle

@Composable
fun PatternDesignList(
    patterns: List<PatternDesign>,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),
) {

}

@Composable
fun PatternDesignItem(patternDesign: PatternDesign, modifier: Modifier = Modifier) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), modifier = modifier) {

        PatternImage(imageRes = patternDesign.imageRes)
        PatternInformation(
            nameRes = patternDesign.nameRes,
            type = patternDesign.patternType,
            colorType = patternDesign.colorType,
        )
    }
}

@Composable
fun PatternImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier


    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = modifier
                .clip(shape = MaterialTheme.shapes.small)
                .height(130.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center,
        )

    }
}


@Composable
fun PatternInformation(
    @StringRes nameRes: Int,
    type: PatternType,
    colorType: Color,
    modifier: Modifier = Modifier
) {

    Row {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = nameRes),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        style =
                        customSpanStyle(MaterialTheme.typography.labelSmall)
                    ) {
                        append("Tipo de patrón: ")
                    }
                    withStyle(
                        style = customSpanStyle(
                            MaterialTheme.typography.labelMedium,
                            color = colorType
                        )
                    )
                    {
                        append(type.name)
                    }
                }
            )
        }
    }
}

@Composable
fun PatternItemButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier) {

}

@Composable
fun InformationExtend(descriptionRes: Int, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun PatternDesignItemPreview() {
    PatternDesignAppTheme {
        val patternDesign = PatternsDesignRepository.patterns[1]
        PatternDesignItem(patternDesign = patternDesign)
    }

}

