package com.example.weatherapp.data.weather

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.weather.local.WeatherDao
import com.example.weatherapp.data.weather.local.tables.City

class WeatherRepository (
    private val weatherDao: WeatherDao
){

    val cities: LiveData<City> = weatherDao.getCityForecast()

    suspend fun addCity(city: City){
        weatherDao.addCity(city)
    }
}