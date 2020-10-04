package com.example.daily_weather_feature.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bddweather.api.WeatherApiService
import com.example.bddweather.data.WeatherDao
import com.example.daily_weather.R
import com.example.daily_weather_feature.repo.DailyWeatherRepository

class DailyWeatherFragment : Fragment() {

    private val dailyWeatherRepository = DailyWeatherRepository(
        WeatherDao(), WeatherApiService()
    )
    var viewmodel = DailyWeatherViewModel(dailyWeatherRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.dailyForecast()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_weather, container, false)
    }

}