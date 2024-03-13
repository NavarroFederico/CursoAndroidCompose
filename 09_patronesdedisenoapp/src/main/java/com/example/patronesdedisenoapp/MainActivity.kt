package com.example.patronesdedisenoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.patronesdedisenoapp.model.PatternsDesignRepository
import com.example.patronesdedisenoapp.ui.theme.PatternDesignAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatternDesignAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PatternDesignApp()
                }
            }
        }
    }
}

@Composable
fun PatternDesignApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { PatternDesignTopAppBar() }
    ) {
        val patternList = PatternsDesignRepository.patterns
        PatternDesignList(patternsList = patternList, contentPaddingValues = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatternDesignTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.primaryContainer,
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PatternDesignAppTheme {
        PatternDesignList(patternsList = PatternsDesignRepository.patterns)
    }
}