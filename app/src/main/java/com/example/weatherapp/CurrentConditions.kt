package com.example.weatherapp

import com.squareup.moshi.Json

data class CurrentConditions(
    @Json(name = "weather") private val weatherDescriptionList : List<WeatherDescription>,
    @Json(name = "main") private val weatherData : WeatherData,
    @Json(name = "name") val locationName : String
) {
    val weatherIconUrl : String
        get() = "https://openweathermap.org/img/wn/${weatherDescriptionList.firstOrNull()?.icon}@2x.png"
    val weatherDescription : String?
        get() = weatherDescriptionList.firstOrNull()?.description
    val currentTemp : Float
        get() = weatherData.currentTemp
    val feelsLike : Float
        get() = weatherData.feelsLike
    val pressure : Float
        get() = weatherData.pressure
    val humidity : Int
        get() = weatherData.humidity
    val maxTemp : Float
        get() = weatherData.maxTemp
    val minTemp : Float
        get() = weatherData.minTemp
}

data class WeatherDescription(
    val description : String,
    val icon : String

)

data class WeatherData(
    @Json(name = "temp") val currentTemp : Float,
    @Json(name = "feels_like") val feelsLike : Float,
    val pressure : Float,
    val humidity : Int,
    @Json(name = "temp_min") val minTemp : Float,
    @Json(name = "temp_max") val maxTemp : Float
)