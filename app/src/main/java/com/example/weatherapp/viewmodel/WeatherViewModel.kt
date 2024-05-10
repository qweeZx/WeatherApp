package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState = _uiState.asStateFlow()
}