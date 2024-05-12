package com.example.weatherapp.viewmodel


data class ForecastByDayUiState(
    val dayOfWeek: String = "Monday",
    val date: String = "22 may",
    val maxTemp: Int = 10,
    val minTemp: Int = 0,
    val condition: String = "Sunny"
)
