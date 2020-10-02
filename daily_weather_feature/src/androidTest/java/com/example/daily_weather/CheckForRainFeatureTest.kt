package com.example.daily_weather

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bddweather.MainActivity
import com.example.core_android_test.given
import com.example.daily_weather.steps.ApiSteps.it_is_expected_to_rain_within_twelve_hours
import org.hamcrest.Matchers.allOf
import com.example.core_android_test.haveStateThat
import com.example.daily_weather.steps.ApiSteps.it_is_not_expected_to_rain_within_twelve_hours
import org.hamcrest.Matchers.not
import org.junit.Rule
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

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_user_sees_a_rain_indicator_when_it_is_expected_to_rain() {
        given { it_is_expected_to_rain_within_twelve_hours()
        }.on { // I navigate to the daily weather screen: No operation -- this is currently the landing screen
        }.check(R.id.main_weather_text_view) {
             it should haveStateThat(matches(allOf(withText("Rain"), isDisplayed())))
             it should haveStateThat(matches(not(withText("Sun"))))
            // TODO: And I should see a rain cloud
            // TODO: And I should not see a sun
        }
    }

    @Test
    fun a_user_sees_a_sun_indicator_when_it_is_not_expected_to_rain() {
        given { it_is_not_expected_to_rain_within_twelve_hours()
        }.on { // I navigate to the daily weather screen: No operation -- this is currently the landing screen
        }.check(R.id.main_weather_text_view) {
            it should haveStateThat(matches(allOf(withText("Sun"), isDisplayed())))
            it should haveStateThat(matches(not(withText("Rain"))))
            // TODO: And I should see a sun
            // TODO: And I should not see a rain cloud
        }
    }

}
