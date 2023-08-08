package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.ui.MyApplicationTheme
import com.example.weatherapp.ui.PurpleGrey40
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "CurrentConditions") {
                        composable(route = "CurrentConditions") {
                            CurrentWeather {
                                navController.navigate(route = "Forecast")
                            }
                        }

                        composable(route = "Forecast") {
                            ForecastList()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeather(viewModel: CurrentConditionsViewModel = hiltViewModel(), navTo: () -> Unit) {
    val currentWeather = viewModel.currentConditions.observeAsState()
    LaunchedEffect(Unit) {
        viewModel.viewAppeared()
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.weatherApp),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(red = 200, green = 200, blue = 200),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = PurpleGrey40,
                scrolledContainerColor = MaterialTheme.colorScheme.surface
            )
        )
        Text(
            text = currentWeather.value?.locationName ?: "Nowhere",
            style = MaterialTheme.typography.headlineMedium,
            color = PurpleGrey40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(0.6f)) {
                Text(
                    text = "${currentWeather.value?.currentTemp?.roundToInt()}" + stringResource(id = R.string.degF),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.feels_like),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .weight(2f)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier)
                    Text(
                        text = "${currentWeather.value?.feelsLike?.roundToInt()}" + stringResource(id = R.string.degF),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }
            Column(modifier = Modifier.weight(0.4f)) {
                WeatherConditionIcon(url = currentWeather.value?.weatherIconUrl)
            }
        }
        Row {
            Text(
                text = stringResource(id = R.string.daily_low),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier)
            Text(
                text = "${currentWeather.value?.minTemp?.roundToInt()}" + stringResource(id = R.string.degF),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.daily_high),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier)
            Text(
                text = "${currentWeather.value?.maxTemp?.roundToInt()}" + stringResource(id = R.string.degF),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.humidity),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier)
            Text(
                text = "${currentWeather.value?.humidity}%",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.atmosphere_pressure),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier)
            Text(
                text = "${currentWeather.value?.pressure}" + stringResource(id = R.string.atmosphere_units),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier)
            Button(onClick = navTo) {
                Text(text = stringResource(id = R.string.button_text))
            }
            Spacer(modifier = Modifier)
        }
    }
}

@Composable
fun WeatherConditionIcon(url: String?) {
    Image(
        painter = rememberAsyncImagePainter(model = url),
        contentDescription = "",
        modifier = Modifier.fillMaxWidth()
    )
}

