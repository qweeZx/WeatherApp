package com.example.weatherapp.data.weather

import android.app.Application
import android.util.Log
import com.example.weatherapp.data.weather.local.WeatherDao
import com.example.weatherapp.data.weather.local.WeatherDatabase
import com.example.weatherapp.data.weather.local.tables.City
import com.example.weatherapp.data.weather.remote.WeatherApi
import com.example.weatherapp.data.weather.remote.WeatherApiService
import com.example.weatherapp.data.weather.remote.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class WeatherRepository (
    application: Application
){
    private val weatherDao: WeatherDao
    private val weatherApiService: WeatherApiService
    init {
        Log.d("mytag", "4")
        weatherDao = WeatherDatabase.getDatabase(application).getWeatherDao()
        Log.d("mytag", "5")
        weatherApiService = WeatherApi.retrofitService
        Log.d("mytag", "6")
    }

    suspend fun updateWeatherForecast(){
        withContext(Dispatchers.IO){
            val weather = weatherApiService.getWeather(location = "London")
        }
    }

    suspend fun addCity(city: String){
        weatherDao.addCity(City(city = city))
    }


}