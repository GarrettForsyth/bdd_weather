package com.example.daily_weather_feature.steps

import com.example.daily_weather_feature.enqueueResponseFromFile
import okhttp3.mockwebserver.MockWebServer

object ApiSteps {

    fun it_is_expected_to_rain_within_twelve_hours() {
        val mockWebServer = MockWebServer()
        mockWebServer.enqueueResponseFromFile("api_responses/onecall_rain_response.json", this::class.java)
    }

    fun it_is_not_expected_to_rain_within_twelve_hours() {
        val mockWebServer = MockWebServer()
        mockWebServer.enqueueResponseFromFile("api_responses/onecall_no_rain_response.json", this::class.java)
    }

}
