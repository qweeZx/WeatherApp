package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: WeatherViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    WeatherAppTheme {
        Surface {
            Column {
                Text(text = "header")
                CurrentWeatherCard(uiState = uiState)
                LazyRow {
                    items(uiState.value.forecastByDays){
                        ForecastByDaysCard(uiState = it)
                    }
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}