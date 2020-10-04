package com.example.daily_weather_feature.repo

import com.example.bddweather.api.ApiResponse
import com.example.bddweather.api.WeatherApiService
import com.example.bddweather.data.WeatherDao
import com.example.bddweather.repo.NetworkBoundResource
import com.example.bddweather.vo.Resource
import com.example.bddweather.vo.Weather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class DailyWeatherRepository(
    val dao: WeatherDao,
    val api: WeatherApiService
) {
    fun dailyForecast(): Flow<Resource<Weather>> {
        return object : NetworkBoundResource<Weather, Weather>() {
            override suspend fun saveNetworkResult(item: Weather) {}
            override fun shouldFetch(data: Weather?) = false
            override suspend fun loadFromDb(): Flow<Weather> = dao.dailyForecast()
            override suspend fun fetchFromNetwork(): ApiResponse<Weather> =  ApiResponse.Companion.create(Throwable())
        }.asFlow()
    }
}