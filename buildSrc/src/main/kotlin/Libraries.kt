object Libraries {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }
    object Compatibility {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}" // Kotlin extension to common libraries of the Android Framework
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}" // Allows access to new APIs on older API versions of the platform
        const val playCore = "com.google.android.play:core:${Versions.playCore}" // Needed for on demand features
        const val playCoreKtx = "com.google.android.play:core-ktx:${Versions.playCoreKtx}" // Kotlin extensions for playcore
    }
    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" // Complex view hierarchies
        const val material = "com.google.android.material:material:${Versions.material}" // Support for following material design guidelines
    }

    object Test {
        object Unit {
            const val junit4 =  "junit:junit:${Versions.junit4}" // Unit testing framework
        }
        object Feature {
            const val axEspresso = "androidx.test.espresso:espresso-core:${Versions.axEspresso}" // UI test framework
        }
        object Common {
            const val axJunit4 = "androidx.test.ext:junit:${Versions.axJunit4}" // Rules and test runners
            const val assertK = "com.willowtreeapps.assertk:assertk-jvm:${Versions.assertK}" // Readable assertions for Kotlin
            const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}" // Mocking framework for Kotlin
        }
    }
}