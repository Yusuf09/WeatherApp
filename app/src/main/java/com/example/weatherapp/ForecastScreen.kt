import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import java.text.SimpleDateFormat
import java.util.*

data class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: ForecastTemp,
    val pressure: Float,
    val humidity: Int
)

data class ForecastTemp(
    val day: Float,
    val min: Float,
    val max: Float
)

@Composable
fun ForecastScreen(forecastItems: List<DayForecast>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow)
        ) {
            Text(
                text = "Forecast",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(10.dp)
            )
        }
        LazyColumn {
            items(forecastItems) { dayForecast ->

                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.weather_icon),
                            contentDescription = "Weather Icon",
                            modifier = Modifier.size(48.dp)
                        )

                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = formatDate(dayForecast.date),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }

                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Box {
                            Column {
                                Text(
                                    text = "Temp: ${dayForecast.temp.day.toInt()}°",
                                    style = MaterialTheme.typography.body2
                                )
                                Row {
                                    Text(
                                        text = "High: ${dayForecast.temp.max.toInt()}°",
                                        style = MaterialTheme.typography.body2
                                    )
                                    Text(
                                        text = "Low: ${dayForecast.temp.min.toInt()}°",
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Box(modifier = Modifier.padding(top = 8.dp)) {
                            Column {
                                Text(
                                    text = "Sunrise: ${formatTime(dayForecast.sunrise)}",
                                    style = MaterialTheme.typography.body2
                                )
                                Text(
                                    text = "  Sunset: ${formatTime(dayForecast.sunset)}",
                                    style = MaterialTheme.typography.body2
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("MMM dd", Locale.getDefault())
    return sdf.format(Date(timestamp * 1000))
}

@Composable
fun formatTime(timestamp: Long): String {
    val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return sdf.format(Date(timestamp * 1000))
}

@Preview(showBackground = true)
@Composable
fun PreviewForecastScreen() {
    val forecastItems = listOf(
        DayForecast(1L, 1675173600L, 1675177200L, ForecastTemp(72.0f, 65.0f, 80.0f), 1013.25f, 50),
        DayForecast(2L, 1675173500L, 1675177300L, ForecastTemp(75.0f, 68.5f, 83.5f), 1015.15f, 55),
        DayForecast(3L, 1675173400L, 1675177400L, ForecastTemp(71.0f, 64.0f, 79.0f), 1017.05f, 60),
        DayForecast(4L, 1675173300L, 1675177500L, ForecastTemp(73.0f, 66.3f, 81.7f), 1010.35f, 52),
        DayForecast(5L, 1675173200L, 1675177600L, ForecastTemp(70.0f, 63.1f, 78.2f), 1009.45f, 58),
        DayForecast(6L, 1675173100L, 1675177700L, ForecastTemp(74.0f, 67.4f, 82.4f), 1018.25f, 53),
        DayForecast(7L, 1675173000L, 1675177800L, ForecastTemp(69.0f, 62.2f, 77.1f), 1015.35f, 59),
        DayForecast(8L, 1675172900L, 1675177900L, ForecastTemp(76.0f, 69.6f, 84.8f), 1016.05f, 54),
        DayForecast(9L, 1675172800L, 1675178000L, ForecastTemp(68.0f, 57.3f, 74.6f), 1014.15f, 60),
        DayForecast(10L, 1675172700L, 1675178100L, ForecastTemp(72.0f, 65.0f, 80.3f), 1013.25f, 50),
        DayForecast(11L, 1675172600L, 1675178200L, ForecastTemp(75.0f, 68.5f, 83.7f), 1007.15f, 55),
        DayForecast(12L, 1675172500L, 1675178300L, ForecastTemp(71.0f, 62.2f, 79.4f), 1019.05f, 60),
        DayForecast(13L, 1675172400L, 1675178400L, ForecastTemp(74.0f, 65.1f, 82.2f), 1017.25f, 53),
        DayForecast(14L, 1675172300L, 1675178500L, ForecastTemp(69.0f, 60.6f, 77.8f), 1012.35f, 59),
        DayForecast(15L, 1675172200L, 1675178600L, ForecastTemp(76.0f, 67.3f, 84.6f), 1016.05f, 54),
        DayForecast(16L, 1675172100L, 1675178700L, ForecastTemp(75.0f, 66.3f, 85.6f), 1010.05f, 54),
    )
    ForecastScreen(forecastItems = forecastItems)
}
