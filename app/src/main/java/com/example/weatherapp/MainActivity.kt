package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp(stringResource(R.string.weatherApp))
        }
    }
}

@Composable
fun WeatherApp(stringResource: String?) {

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
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewWeatherApp() {
    WeatherApp(stringResource(R.string.weatherApp))
}