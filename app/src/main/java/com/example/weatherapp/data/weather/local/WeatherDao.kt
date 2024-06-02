package com.example.weatherapp.data.weather.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.weather.local.tables.City

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCity(city: City)

    @Query("SELECT * FROM cities ")
    fun getCityForecast(): LiveData<City>
}