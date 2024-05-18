package com.example.weatherapp.viewmodel


data class ForecastByDayUiState(
    val dayOfWeek: String = "Monday",
    val date: String = "22 may",
    val maxTemp: Int = 80,
    val minTemp: Int = 80,
    val condition: String = "Sunny"
)
