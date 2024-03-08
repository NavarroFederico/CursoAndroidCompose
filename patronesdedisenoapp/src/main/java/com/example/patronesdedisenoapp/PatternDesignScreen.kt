package com.example.patronesdedisenoapp

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patronesdedisenoapp.model.PatternDesign
import com.example.patronesdedisenoapp.model.PatternsDesignRepository
import com.example.patronesdedisenoapp.ui.theme.PatternDesignAppTheme
import com.example.patronesdedisenoapp.ui.util.AnnotatedClickableText

import com.example.patronesdedisenoapp.ui.util.AnnotatedClickableText
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
    var expanded by remember { mutableStateOf(false) }

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), modifier = modifier) {

        PatternImage(imageRes = patternDesign.imageRes)
        Row(modifier = Modifier.padding(16.dp)) {
            PatternInformation(
                nameRes = patternDesign.nameRes,
                patternDesignRes = patternDesign.patternTypeRes,
                colorType = patternDesign.colorType,

                )
            Spacer(modifier = Modifier.weight(1F))
            PatternItemButton(
                expanded = expanded,
                onClick = { expanded = !expanded },
                modifier = modifier
            )
        }
        if (expanded) {
            ExtendInformation(
                descriptionRes = patternDesign.descriptionRes,
                urlLink = patternDesign.url
            )
        }
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
    @StringRes patternDesignRes: Int,
    colorType: Color,
    modifier: Modifier = Modifier
) {

    Column() {
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
                    append(stringResource(id = patternDesignRes))
                }
            }
        )
    }
}

@Composable
fun PatternItemButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ExtendInformation(descriptionRes: Int, modifier: Modifier = Modifier, urlLink: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 24.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            buildAnnotatedString {
                withStyle(
                    style = customSpanStyle(style = MaterialTheme.typography.bodyMedium)
                ) {
                    append(stringResource(id = descriptionRes))
                }

            }
        )

        val annotatedText = buildAnnotatedString {
            withStyle(style = customSpanStyle(style = MaterialTheme.typography.bodyMedium)) {
                append(stringResource(R.string.para_m_s_info_click))
            }
            //This function call adds an annotation with the specified tag ("URL") and value (the URL string from the resource ID) to the annotatedText
            pushStringAnnotation(
                tag = "URL", annotation = stringResource(id = urlLink)
            )
            withStyle(
                style = customSpanStyle(
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Blue
                )
            ) {
                append(stringResource(R.string.aqui))
            }
            pop()
        }

        val uriHandler = LocalUriHandler.current

        ClickableText(
            text = annotatedText,
            style = MaterialTheme.typography.displayLarge,
            onClick = { offset ->
                // We check if there is an *URL* annotation attached to the text
                // at the clicked position
                annotatedText.getStringAnnotations(
                    tag = "URL", start = offset, end = offset
                ).firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    uriHandler.openUri(annotation.item)
                    Log.d("Clicked URL", annotation.item)
                }
            })
    }
}


@Preview(showBackground = true)
@Composable
fun PatternDesignItemPreview() {
    PatternDesignAppTheme {
        val patternDesign = PatternsDesignRepository.patterns[1]
        PatternDesignItem(patternDesign = patternDesign)
    }

}

