package com.example.bddweather.data

import com.example.bddweather.vo.Weather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class WeatherDao {
    fun dailyForecast(): Flow<Weather> = emptyFlow()
}