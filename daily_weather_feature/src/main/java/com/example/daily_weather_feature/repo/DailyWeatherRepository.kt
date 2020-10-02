package com.example.daily_weather_feature.repo

import com.example.bddweather.vo.Weather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class DailyWeatherRepository {
    fun dailyForecast(): Flow<Weather> = emptyFlow()
}