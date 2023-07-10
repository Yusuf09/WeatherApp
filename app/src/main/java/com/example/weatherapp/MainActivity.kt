package com.example.weatherapp

import DayForecast
import ForecastScreen
import ForecastTemp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "weather") {
                composable("weather") {
                    WeatherApp(navController = navController)
                }
                composable("ForecastScreen") {
                    val forecastItems = getForecastItems()
                    ForecastScreen(forecastItems = getForecastItems())
                }
            }
        }
    }
}

@Composable
fun getForecastItems(): List<DayForecast> {
    return listOf(
        DayForecast(
            date = 1L,
            sunrise = 1675173600L,
            sunset = 1675177200L,
            temp = ForecastTemp(day = 72.0f, min = 65.0f, max = 80.0f),
            pressure = 1013.25f,
            humidity = 50
        ),
        DayForecast(
            date = 2L,
            sunrise = 1675173500L,
            sunset = 1675177300L,
            temp = ForecastTemp(day = 75.0f, min = 68.5f, max = 83.5f),
            pressure = 1015.15f,
            humidity = 55
        ),
        DayForecast(
            date = 3L,
            sunrise = 1675173400L,
            sunset = 1675177400L,
            temp = ForecastTemp(day = 71.0f, min = 64.0f, max = 79.0f),
            pressure = 1017.05f,
            humidity = 60
        ),
        DayForecast(
            date = 4L,
            sunrise = 1675173300L,
            sunset = 1675177500L,
            temp = ForecastTemp(day = 73.0f, min = 66.3f, max = 81.7f),
            pressure = 1010.35f,
            humidity = 52
        ),
        DayForecast(
            date = 5L,
            sunrise = 1675173200L,
            sunset = 1675177600L,
            temp = ForecastTemp(day = 70.0f, min = 63.1f, max = 78.2f),
            pressure = 1009.45f,
            humidity = 58
        ),
        DayForecast(
            date = 6L,
            sunrise = 1675173100L,
            sunset = 1675177700L,
            temp = ForecastTemp(day = 74.0f, min = 67.4f, max = 82.4f),
            pressure = 1018.25f,
            humidity = 53
        ),
        DayForecast(
            date = 7L,
            sunrise = 1675173000L,
            sunset = 1675177800L,
            temp = ForecastTemp(day = 69.0f, min = 62.2f, max = 77.1f),
            pressure = 1015.35f,
            humidity = 59
        ),
        DayForecast(
            date = 8L,
            sunrise = 1675172900L,
            sunset = 1675177900L,
            temp = ForecastTemp(day = 76.0f, min = 69.6f, max = 84.8f),
            pressure = 1016.05f,
            humidity = 54
        ),
        DayForecast(
            date = 9L,
            sunrise = 1675172800L,
            sunset = 1675178000L,
            temp = ForecastTemp(day = 68.0f, min = 57.3f, max = 74.6f),
            pressure = 1014.15f,
            humidity = 60
        ),
        DayForecast(
            date = 10L,
            sunrise = 1675172700L,
            sunset = 1675178100L,
            temp = ForecastTemp(day = 72.0f, min = 65.0f, max = 80.3f),
            pressure = 1013.25f,
            humidity = 50
        ),
        DayForecast(
            date = 11L,
            sunrise = 1675172600L,
            sunset = 1675178200L,
            temp = ForecastTemp(day = 75.0f, min = 68.5f, max = 83.7f),
            pressure = 1007.15f,
            humidity = 55
        ),
        DayForecast(
            date = 12L,
            sunrise = 1675172500L,
            sunset = 1675178300L,
            temp = ForecastTemp(day = 71.0f, min = 62.2f, max = 79.4f),
            pressure = 1019.05f,
            humidity = 60
        ),
        DayForecast(
            date = 13L,
            sunrise = 1675172400L,
            sunset = 1675178400L,
            temp = ForecastTemp(day = 74.0f, min = 65.1f, max = 82.2f),
            pressure = 1017.25f,
            humidity = 53
        ),
        DayForecast(
            date = 14L,
            sunrise = 1675172300L,
            sunset = 1675178500L,
            temp = ForecastTemp(day = 69.0f, min = 60.6f, max = 77.8f),
            pressure = 1012.35f,
            humidity = 59
        ),
        DayForecast(
            date = 15L,
            sunrise = 1675172200L,
            sunset = 1675178600L,
            temp = ForecastTemp(day = 76.0f, min = 67.3f, max = 84.6f),
            pressure = 1016.05f,
            humidity = 54
        ),
        DayForecast(
            date = 16L,
            sunrise = 1675172100L,
            sunset = 1675178700L,
            temp = ForecastTemp(day = 75.0f, min = 66.3f, max = 85.6f),
            pressure = 1010.05f,
            humidity = 54
        )
    )
}

@Composable
fun WeatherApp(navController: NavHostController) {

    val imagePainter = painterResource(R.drawable.weather_icon)


    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Green)
            ) {
                Text(
                    text = " My Weather App",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "St.Paul,MN",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "72°",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.alignByBaseline()
                )

                Spacer(modifier = Modifier.width(30.dp))


                Image(
                    painter = imagePainter,
                    contentDescription = "01d",
                    modifier = Modifier.size(128.dp)
                )


            }

            Text(
                text = "Feels like 78°",
                modifier = Modifier.padding(start = 80.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Low 65°",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 45.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "High 80°",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 45.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Humidity 100%",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 45.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Pressure 1023 hPa",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 45.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.End)
                    .background(color = Color.Gray)
            ) {
                Button(
                    onClick = {
                        navController.navigate("ForecastScreen")
                    },
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp)
                ) {
                    Text(
                        text = "Forecast",
                        style = MaterialTheme.typography.button,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherApp() {
    val navController = rememberNavController()
    WeatherApp(navController)
}