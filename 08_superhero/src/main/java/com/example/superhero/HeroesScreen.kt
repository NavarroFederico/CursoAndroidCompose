package com.example.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.data.HeroesRepository
import com.example.superhero.model.Hero
import com.example.superhero.ui.theme.SuperheroesTheme

@Composable
fun HeroesList(
    heroes: List<Hero>, contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    LazyColumn(contentPadding = contentPadding) {
        items(heroes) { hero ->
            HeroListItem(
                hero = hero, modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), modifier = modifier

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .heightIn(min = 72.dp)
        )
        {
            HeroInformation(hero.nameRes, hero.descriptionRes, modifier.weight(1f))
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
    Column(modifier = modifier) {
        Text(text = stringResource(id = nameRes), style = MaterialTheme.typography.displaySmall)
        Text(
            text = stringResource(id = descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroIcon(@DrawableRes imageRes: Int, @StringRes stringRes: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .height(72.dp)
            .aspectRatio(ratio = 1.0f)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(stringRes),
            modifier = modifier.clip(shape = MaterialTheme.shapes.small),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun HeroesItemPreview() {
    SuperheroesTheme {
        HeroListItem(
            hero = HeroesRepository.heroes[3],
        )
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun HeroListItemPreview() {
    SuperheroesTheme {
        HeroesList(heroes = HeroesRepository.heroes)
    }
}
