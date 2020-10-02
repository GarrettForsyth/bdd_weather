package com.example.daily_weather.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.daily_weather.R
import com.example.daily_weather_feature.ui.DailyWeatherFragment
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DailyWeatherFragmentTest {

    private lateinit var scenario: FragmentScenario<DailyWeatherFragment>

    @Before
    fun launchFragment() {
        scenario = launchFragmentInContainer<DailyWeatherFragment>(
                fragmentArgs = null,
                themeResId = com.example.bddweather.R.style.Theme_BDDWeather,
                factory = DailyWeatherFragmentFactory()

        )
    }

    @Test
    fun when_launched_it_should_display_initial_views() {
        onView(withId(R.id.main_weather_text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun when_launched_it_should_query_viewmodel_for_weather() {
        scenario.onFragment {
            verify { it.viewmodel.dailyForecast() }
        }
    }
}
class DailyWeatherFragmentFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return (super.instantiate(classLoader, className) as DailyWeatherFragment).apply {
            viewmodel = mockk(relaxed = true)
        }
    }
}
