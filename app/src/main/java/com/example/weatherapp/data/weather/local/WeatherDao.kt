package com.example.weatherapp.data.weather.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.weather.local.tables.City
import com.example.weatherapp.data.weather.local.tables.CurrentWeather

@Dao
interface WeatherDao {

    @Insert(entity = City::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCity(city: City)

    @Delete
    suspend fun deleteCity(city: City)

    @Query("SELECT * FROM cities ")
    fun getAllCities(): LiveData<City>

    @Query("SELECT * FROM current_weather WHERE id = :id")
    suspend fun getCurrentWeather(id: Int): CurrentWeather

    @Query("UPDATE current_weather SET temperature = 0, condition = 'Sunny', time = '', date = ''  WHERE id = :id")
    suspend fun updateCurrentWeather(id: Int)
}