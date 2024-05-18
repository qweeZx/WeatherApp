package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherUiState
import com.example.weatherapp.viewmodel.WeatherViewModel

@Composable
fun CurrentWeatherCard(
    modifier: Modifier = Modifier,
    uiState: WeatherUiState
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(text = uiState.currentDate, modifier = Modifier.align(Alignment.CenterStart))
                Text(text = uiState.dayOfWeek, modifier = Modifier.align(Alignment.Center))
                Text(text = uiState.currentTime, modifier = Modifier.align(Alignment.CenterEnd))
            }
            Text(
                text = stringResource(R.string.current_temp_degrees_celsius, uiState.currentTemperature),
                fontSize = 40.sp)
            Text(text = uiState.currentCondition)
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun CurrentWeatherCardPreview() {
    val viewModel: WeatherViewModel = viewModel()
    val uiState = viewModel.uiState
    WeatherAppTheme {
        Surface {
            CurrentWeatherCard(uiState = uiState)
        }
    }
}