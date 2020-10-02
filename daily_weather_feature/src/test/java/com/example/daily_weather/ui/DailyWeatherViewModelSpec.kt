package com.example.daily_weather.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.bddweather.vo.Weather
import com.example.core_test.rules.withTestRules
import com.example.core_test.utils.getValueBlocking
import com.example.daily_weather_feature.repo.DailyWeatherRepository
import com.example.daily_weather_feature.ui.DailyWeatherViewModel
import io.mockk.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class DailyWeatherViewModelSpec: Spek({
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    withTestRules(instantTaskExecutorRule)

    describe("a DailyWeatherViewModel") {
        val dailyWeatherRepository: DailyWeatherRepository = mockk()
        val dailyWeatherViewModel by memoized { DailyWeatherViewModel(dailyWeatherRepository) }
        describe("dailyForecast") {
            val liveDataResults = MutableLiveData<Weather>()
            beforeEachTest {
                mockkStatic("androidx.lifecycle.FlowLiveDataConversions")
                every {
                    dailyWeatherRepository
                            .dailyForecast()
                            .asLiveData()
                } returns liveDataResults

                dailyWeatherViewModel.dailyForecast()
            }
            it("queries the DailyWeatherRepository for daily forecast data to provide") {
                verify { dailyWeatherRepository.dailyForecast() }
            }
            it("provides the daily forecast data for the UI") {
                val dailyForecastResults: Weather = mockk()
                liveDataResults.value = dailyForecastResults
                assertThat(
                    dailyWeatherViewModel
                        .dailyForecast()
                        .getValueBlocking()
                ).isEqualTo(dailyForecastResults)
            }
        }
    }
})

