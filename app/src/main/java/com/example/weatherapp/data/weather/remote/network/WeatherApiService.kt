package com.example.weatherapp.data.weather.remote.network

import android.util.Log
import com.example.weatherapp.data.weather.remote.model.Weather
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.weatherapi.com/v1/"
private const val API_KEY = "18fb556df372430996682255241205"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String = API_KEY,
        @Query("q") location: String,
        @Query("days") days: Int = 10,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Weather
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        Log.d("my", "lazy")
        retrofit.create(WeatherApiService::class.java)
    }
}