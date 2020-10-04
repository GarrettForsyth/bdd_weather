object Libraries {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }
    object Compatibility {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}" // Kotlin extension to common libraries of the Android Framework
        const val navKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}" // Nav extensions
        const val playCoreKtx = "com.google.android.play:core-ktx:${Versions.playCoreKtx}" // Kotlin extensions for playcore

        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}" // Allows access to new APIs on older API versions of the platform
        const val playCore = "com.google.android.play:core:${Versions.playCore}" // Needed for on demand features
        const val navFeatureSupport = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav}" // Needed for nav with feature modules
    }
    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" // Complex view hierarchies
        const val material = "com.google.android.material:material:${Versions.material}" // Support for following material design guidelines
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav}" // Nav ui
    }
    object LifeCycle {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" // ViewModel
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" // LiveData
        const val lifecycles = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"  // Lifecycles only (without ViewModel or LiveData)
        const val saveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}" // Saved state module for ViewModel
        const val compiler = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}" // Extensions and coroutine support
        const val test = "androidx.room:room-testing:${Versions.room}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    }

    object Test {
        object Unit {
            const val junit5 = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}" // Unit Testing Framework
            const val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
            const val spek = "org.spekframework.spek2:spek-dsl-jvm:${Versions.spek}"
            const val spekRunner = "org.spekframework.spek2:spek-runner-junit5:${Versions.spek}"
            const val arch = "androidx.arch.core:core-testing:${Versions.arch}"
            const val coroutineTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
        }
        object Feature {
            const val axEspresso = "androidx.test.espresso:espresso-core:${Versions.axEspresso}" // UI test framework
            const val fragment = "androidx.fragment:fragment-testing:${Versions.fragment}" // Test fragments in isolation
            const val navTest =  "androidx.navigation:navigation-testing:${Versions.nav}" // nav test support
        }
        object Common {
            const val axJunit4 = "androidx.test.ext:junit:${Versions.axJunit4}" // Rules and test runners
            const val assertK = "com.willowtreeapps.assertk:assertk-jvm:${Versions.assertK}" // Readable assertions for Kotlin
            const val mockk = "io.mockk:mockk:${Versions.mockk}"
            const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
            const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}" // Mocking framework for Kotlin
        }
    }
}