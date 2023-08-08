package com.example.weatherapp

import com.squareup.moshi.Json

data class ForecastLists(
    @Json(name = "list") val forecastList: List<DayForecast>
)

data class DayForecast(
    @Json(name = "dt") val date: Long,
    val sunrise: Long,
    val sunset: Long,
    @Json(name = "temp") private val tempData: ForecastTemp,
    @Json(name = "weather") private val weatherDescriptionList: List<WeatherDescription>,
) {
    val daytimeTemp : Float
        get() = tempData.day
    val minTemp : Float
        get() = tempData.min
    val maxTemp : Float
        get() = tempData.max
    val weatherIconUrl : String
        get() = "https://openweathermap.org/img/wn/${weatherDescriptionList.firstOrNull()?.icon}@2x.png"
}

data class ForecastTemp(
    val day: Float,
    val min: Float,
    val max: Float
)