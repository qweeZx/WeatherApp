package com.example.weatherapp.data.weather.local.tables

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "current_weather",
    foreignKeys = [
    ]
)
data class CurrentWeather(
    @PrimaryKey val id: Int,
    val temperature: Int,
    val condition: String,
    val time: String,
    val date: String
)
