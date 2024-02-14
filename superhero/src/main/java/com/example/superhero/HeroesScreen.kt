package com.example.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.data.HeroesRepository
import com.example.superhero.model.Hero
import com.example.superhero.ui.theme.SuperheroesTheme

@Composable
fun SuperheroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

        ) {
        Row(modifier = Modifier
            .padding(16.dp)
            .height(72.dp)) {
            HeroInformation(hero.nameRes, hero.descriptionRes)
            Spacer(modifier = Modifier.width(16.dp))
            HeroIcon(hero.imageRes, hero.nameRes)
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = stringResource(id = nameRes), style = MaterialTheme.typography.displaySmall)
        Text(
            text = stringResource(id = descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroIcon(@DrawableRes imageRes: Int, @StringRes stringRes: Int, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.aspectRatio(ratio = 1.0f)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(stringRes),
            modifier = modifier.clip(shape = MaterialTheme.shapes.small)
        )
    }
}

@Preview
@Composable
fun SuperHeroesScreenPreview() {
    SuperheroesTheme {
        SuperheroItem(
            hero = HeroesRepository.heroes[3], modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun SuperHeroeScreenPreview() {
    SuperheroesTheme {
        HeroInformation(
            nameRes = HeroesRepository.heroes[0].nameRes,
            descriptionRes = HeroesRepository.heroes[0].descriptionRes
        )
    }
}