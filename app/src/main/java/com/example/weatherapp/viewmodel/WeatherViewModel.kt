package com.example.weatherapp.viewmodel

import android.icu.util.Calendar
import android.icu.util.Calendar.WeekData
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.weather.remote.model.Weather
import com.example.weatherapp.data.weather.remote.network.WeatherApi
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Date
import java.util.Locale

class WeatherViewModel: ViewModel() {
    var uiState by mutableStateOf(WeatherUiState())
        private set

    init {
        updateWeather()
    }
    fun updateWeather(){
        viewModelScope.launch {
            try {
                val weather = WeatherApi.retrofitService.getWeather(location = "London")
                val dateString = weather.location?.localtime!!
                val date = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH).parse(dateString)
                val dayOfWeek = SimpleDateFormat("EEEE", Locale.ENGLISH).format(date)
                uiState = WeatherUiState(
                    currentTemperature = weather.current?.tempC!!,
                    currentDate = weather.location?.localtime!!.dropLast(5),
                    currentTime = weather.location?.localtime!!.drop(11),
                    currentCondition = weather.current?.condition?.text!!,
                    dayOfWeek = dayOfWeek,
                    forecastByDays = weather.forecast?.forecastday?.map { forecastday ->
                        val dateString = forecastday.date!!
                        val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateString)
                        val dayOfWeek = SimpleDateFormat("EEE", Locale.ENGLISH).format(date)
                        ForecastByDayUiState(
                            dayOfWeek = dayOfWeek,
                            date = forecastday.date!!,
                            maxTemp = forecastday.day?.maxtempC?.toInt()!!,
                            minTemp = forecastday.day?.mintempC?.toInt()!!,
                            condition = forecastday.day?.condition?.text!!
                        )
                    }!!
                )
            } catch (e: Exception) {
                Log.d("my", e.message.toString())
            }
        }
    }
}