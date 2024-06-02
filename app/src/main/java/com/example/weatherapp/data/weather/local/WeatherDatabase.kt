package com.example.weatherapp.data.weather.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.data.weather.local.tables.City
import com.example.weatherapp.data.weather.local.tables.CurrentWeather
import com.example.weatherapp.data.weather.local.tables.Forecast
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [
        City::class,
        CurrentWeather::class,
        Forecast::class],
    version = 1,
    exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun WeatherDao(): WeatherDao

    companion object{
        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_database"
                )
            }
        }
    }

}