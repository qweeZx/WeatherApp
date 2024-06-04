package com.example.weatherapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.ui.MainScreen
import com.example.weatherapp.viewmodel.WeatherViewModel

class WeatherViewModelFactory(val application: Application):
        ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(application) as T
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current

            owner?.let {
                val viewModel: WeatherViewModel = viewModel(
                    it,
                    "WeatherViewModel",
                    WeatherViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                MainScreen(viewModel)
            }
        }
    }
}
