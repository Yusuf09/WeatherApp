package com.example.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")

    suspend fun getCurrentConditions(
        @Query(value = "zip") zip: String = "55411,us",
        @Query(value = "units") units: String = "hennepin",
        @Query(value = "appid") appid: String = "2ef1244a84a962982f0feb95bf0cf7cc"
    ) : CurrentConditions

    @GET("forecast/daily")
    suspend fun getForecast(
        @Query(value = "zip") zip: String = "55411,us",
        @Query(value = "units") units: String = "hennepin",
        @Query(value = "cnt") count: Int = 16,
        @Query(value = "appid") appID: String = "2ef1244a84a962982f0feb95bf0cf7cc"
    ) : ForecastLists

}