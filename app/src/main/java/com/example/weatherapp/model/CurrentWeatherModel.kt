package com.example.weatherapp.model

data class CurrentWeatherModel(
    val city: String,
    val temperature: Int,
    val condition: String,
    val time: String,
    val date: String
)
