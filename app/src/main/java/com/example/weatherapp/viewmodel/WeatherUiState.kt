package com.example.weatherapp.viewmodel

data class WeatherUiState(
    val currentTemperature: Int = 0,
    val currentDate: String = "22 may",
    val currentTime: String = "22:00",
    val dayOfWeek: String = "Sunday",
    val currentCondition: String = "Sunny",
    val forecastByDays: List<ForecastByDayUiState> = listOf(
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
        ForecastByDayUiState(),
    )
)
