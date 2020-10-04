package com.example.daily_weather_feature

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

/**
 * Enqueues a response from file[fileName] using the resources
 * provided by [klass] onto the [MockWebServer].
 */
fun <T> MockWebServer.enqueueResponseFromFile(fileName: String, klass: Class<T>) {
    val response = klass.getResource("/$fileName")?.readText()
    this.enqueue(MockResponse().setResponseCode(200).setBody(response!!))
}

