package com.example.weatherapp.data.weather.local.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecast")
data class Forecast(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val maxTemp: Int,
    val minTemp: Int,
    val date: String,
    val condition: String
)
