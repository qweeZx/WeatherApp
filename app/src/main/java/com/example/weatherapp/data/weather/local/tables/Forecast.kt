package com.example.weatherapp.data.weather.local.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "forecast",
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = ["id"],
            childColumns = ["city_id"]
        )
    ]
)
data class Forecast(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city_id") val cityId: Int,
    val maxTemp: Int,
    val minTemp: Int,
    val date: String,
    val condition: String
)
