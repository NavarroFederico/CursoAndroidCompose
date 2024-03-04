package com.example.patronesdedisenoapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.PatternDesignAppTheme
import com.example.patronesdedisenoapp.model.PatternDesign
import com.example.patronesdedisenoapp.model.PatternsDesignRepository

@Composable
fun PatternDesignList(
    patterns: List<PatternDesign>,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),
) {

}

@Composable
fun PatternDesignItem(patternDesign: PatternDesign, modifier: Modifier = Modifier) {

}

@Composable
fun PatternImage(modifier: Modifier = Modifier) {

}

@Composable
fun PatterInformation() {

}

@Composable
fun PatternItemButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier) {

}

@Composable
fun InformationExtend(descriptionRes: Int, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun PatternDesignItemPreview(){
PatternDesignAppTheme {
    val patternDesign = PatternsDesignRepository.patterns[0]
    PatternDesignItem(patternDesign = patternDesign)
}

}

