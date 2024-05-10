package com.example.weatherapp.model

data class CurrentWeatherModel(
    val city: String,
    val currentTemperature: String,
    val condition: String,
    val conditionIcon: String,
    val maxTemperature: String,
    val minTemperature: String,
)
