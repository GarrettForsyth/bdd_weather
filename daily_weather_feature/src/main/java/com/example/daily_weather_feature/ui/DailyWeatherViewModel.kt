package com.example.daily_weather_feature.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.bddweather.vo.Weather
import com.example.daily_weather_feature.repo.DailyWeatherRepository

class DailyWeatherViewModel(
        val dailyWeatherRepository: DailyWeatherRepository
) {
    fun dailyForecast(): LiveData<Weather>  = dailyWeatherRepository.dailyForecast().asLiveData()
}