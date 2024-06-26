package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.weatherapp.viewmodel.ForecastByDayUiState
import com.example.weatherapp.viewmodel.WeatherViewModel

@Composable
fun ForecastByDaysCard(
    modifier: Modifier = Modifier,
    uiState: ForecastByDayUiState
) {
    Card(
        modifier = modifier
            .size(width = 80.dp, height = 100.dp)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ){
            Text(
                text = uiState.dayOfWeek,
                fontSize = 16.sp
            )
            Text(
                text = uiState.date,
                fontSize = 8.sp
            )
            Text(
                text = stringResource(
                    R.string.max_min_temp_degrees_celsius,
                    uiState.maxTemp, uiState.minTemp),
                fontSize = 16.sp
            )
            Text(
                text = uiState.condition,
                fontSize = 8.sp
                )
        }
    }
}

@Composable
fun ForecastByDaysList(
    modifier: Modifier = Modifier,
    forecastList: List<ForecastByDayUiState>
) {
    LazyRow (
        modifier = modifier
    ){
        items (forecastList) {
            ForecastByDaysCard(uiState = it)
        }
    }
}

@Preview
@Composable
private fun ForecastByDaysListPreview() {
    val viewModel: WeatherViewModel = viewModel()
    val forecastList = viewModel.uiState.forecastByDays
    WeatherAppTheme {
        Surface {
            ForecastByDaysList(forecastList = forecastList)
        }
    }
}

@Preview
@Composable
private fun ForecastByDaysCardPreview() {
    val viewModel: WeatherViewModel = viewModel()
    val uiState = viewModel.uiState.forecastByDays[0]
    WeatherAppTheme {
        Surface {
            ForecastByDaysCard(uiState = uiState)
        }
    }
}