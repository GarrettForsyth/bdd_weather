package com.example.daily_weather_feature.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.bddweather.api.WeatherApiService
import com.example.bddweather.data.WeatherDao
import com.example.bddweather.vo.Resource
import com.example.bddweather.vo.Weather
import com.example.core_test.rules.MainCoroutineScopeRule
import com.example.core_test.rules.withTestRules
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class DailyWeatherRepositorySpec : Spek({

    val coroutineScope = MainCoroutineScopeRule()
    withTestRules(coroutineScope)


    describe("the DailyWeatherRepository") {
        coroutineScope.runBlockingTest {

            val dao: WeatherDao = mockk()
            val resultsChannel = ConflatedBroadcastChannel<Weather>()
            every { dao.dailyForecast() } returns resultsChannel.asFlow()

            val api: WeatherApiService = mockk()

            val dailyWeatherRepository by memoized {
                DailyWeatherRepository(dao, api)
            }


            context("there is recent data in the cache") {
                lateinit var cacheData: Weather
                beforeEachGroup {
                    cacheData = Weather(fetchedAt = System.currentTimeMillis())
                    resultsChannel.offer(cacheData)
                }
                describe("dailyForecast()") {
                    lateinit var result: Resource<Weather>
                    beforeEachTest {
                        launch {
                            // Must use a terminal operation to make the flow emit
                            dailyWeatherRepository.dailyForecast().collect { weather ->
                                result = weather
                            }
                        }
                    }

                    it("queries the local cache once") {
                        verify(exactly = 1) { dao.dailyForecast() }
                    }
                    it("does NOT call the api") {
                        verify(exactly = 0) { api.dailyForecast() }
                    }
                    it("returns the results of the cache") {
                        assertThat(result.data).isEqualTo(cacheData)
                    }
                }
            }
            context("there is no data in the cache") {
                context("fetch a successful result from network") {}
                context("fetch an unsuccessful result from network") {}
            }
            context("there is stale data in the cache") {
                context("fetch a successful result from network") {}
                context("fetch an unsuccessful result from network") {}
            }
        }
    }
})