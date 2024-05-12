package com.example.weatherapp.model

data class ForecastModel(
    val maxTemp: Int,
    val minTemp: Int,
    val date: String,
    val condition: String
)
