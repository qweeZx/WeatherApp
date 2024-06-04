package com.example.weatherapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.weather.WeatherRepository
import com.example.weatherapp.data.weather.local.tables.City
import com.example.weatherapp.data.weather.remote.WeatherApi
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Locale

class WeatherViewModel(application: Application): ViewModel() {
    var uiState by mutableStateOf(WeatherUiState())
        private set

    private val weatherRepository: WeatherRepository

    init {
        Log.d("mytag", "1")
        weatherRepository = WeatherRepository(application)
        Log.d("mytag", "2")
        updateWeather()
        Log.d("mytag", "3")
    }

    fun addCity(city: String){
        viewModelScope.launch {
            weatherRepository.addCity(city)
        }
    }

    fun updateWeather(){
        viewModelScope.launch {
            try {
                val weather = WeatherApi.retrofitService.getWeather(location = "London")
                var dateString = weather.location?.localtime!!
                var date = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH).parse(dateString)
                var dayOfWeek = SimpleDateFormat("EEEE", Locale.ENGLISH).format(date!!)
                uiState = WeatherUiState(
                    location = weather.location?.name!!,
                    currentTemperature = weather.current?.tempC!!.toInt(),
                    currentDate = weather.location?.localtime!!.dropLast(5),
                    currentTime = weather.location?.localtime!!.drop(11),
                    currentCondition = weather.current?.condition?.text!!,
                    dayOfWeek = dayOfWeek,
                    forecastByDays = weather.forecast?.forecastday?.map { forecastday ->
                        dateString = forecastday.date!!
                        date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateString)
                        dayOfWeek = SimpleDateFormat("EEE", Locale.ENGLISH).format(date!!)
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