package com.example.daily_weather

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.core_android_test.given
import com.example.core_android_test.within
import com.example.daily_weather.steps.ApiSteps.it_is_expected_to_rain_within_twelve_hours
import org.hamcrest.Matchers.allOf
import com.example.bddweather.R
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Feature test for a user checking for rain later in the day:
 *  As an outdoor worker
 *  I want to know if it will rain later in the day
 *  So I can bring a raincoat if necessary
 */
@RunWith(AndroidJUnit4::class)
class CheckForRainFeatureTest {
    @Test
    fun a_user_sees_a_rain_indicator_when_it_is_expected_to_rain() {
        given { it_is_expected_to_rain_within_twelve_hours()
        }.on { // I navigate to the daily weather screen: No operation -- this is currently the landing screen
        }.then {
            within(R.id.main_weather_text_view).AssertThatView(matches(allOf(
                    withText("Rain"), isDisplayed())
            ))
            // TODO: And I should see a rain cloud
        }
    }
}
