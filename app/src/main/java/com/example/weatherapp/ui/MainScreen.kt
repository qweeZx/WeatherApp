package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: WeatherViewModel = viewModel()
) {
    val uiState = viewModel.uiState
    WeatherAppTheme {
        Surface {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = uiState.location,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize)
                CurrentWeatherCard(uiState = uiState)
                ForecastByDaysList(forecastList = uiState.forecastByDays)
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}