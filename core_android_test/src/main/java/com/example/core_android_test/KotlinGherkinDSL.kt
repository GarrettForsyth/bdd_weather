package com.example.core_android_test

import assertk.Assert
import assertk.assertAll
import assertk.assertThat

typealias given<S> = Given<S>
class Given<S>(private val setup: () -> S) {
    // 'when' is a keyword in kotlin. use 'on' instead
    fun <R> on(test: S.() -> R): Result<R> = Result { setup().test()  }
}

class Result<R>(private val result: () -> R) {
    fun thenAssert(assert: Assert<R>.() -> Unit) {
        assertThat(result()).assert()
    }
    fun then(assert: Assertions.(R) -> Unit) {
        val assertions = Assertions()
        assertAll {
            assertions.assert(result())
        }
    }

    fun <T> thenCheck(subject: T, assert: Assert<T>.() -> Unit) {
        assertThat(subject).assert()
    }

    fun <T> check(subject: T, assert: Assertions.(T) -> Unit) {
        val assertions = Assertions()
        assertAll {
            assertions.assert(subject)
        }
    }
}

class Assertions {
    infix fun <T> T.should(asserter: Asserter<T>) {
        asserter.assertValue(this)
    }
}

interface Asserter<T> {
    fun assertValue(t: T)
}