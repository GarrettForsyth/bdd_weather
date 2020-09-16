package com.example.core_android_test

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.withId

/**
 * A wrapper class to perform an [Asserter] against a particular [View].
 */
typealias within = WithinView
class WithinView (private val viewId: Int) {

    private val view by lazy { onView(withId(viewId))}

    inner class AssertThatView(private val viewAssertion: ViewAssertion): Asserter<ViewAssertion> {
        override fun assertValue(t: ViewAssertion) {
            view.check(t)
        }
    }
}