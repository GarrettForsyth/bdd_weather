package com.example.core_android_test

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.withId

typealias haveStateThat = AssertThatView
class AssertThatView(private val viewAssertion: ViewAssertion): Asserter<Int> {
    override fun assertValue(t: Int) {
        onView(withId(t)).check(viewAssertion)
    }
}