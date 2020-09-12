object Libraries {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }
    object Compatibility {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}" // Kotlin extension to common libraries of the Android Framework
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}" // Allows access to new APIs on older API versions of the platform
    }
    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" // Complex view hierarchies
        const val material = "com.google.android.material:material:${Versions.material}" // Support for following material design guidelines
    }

    object Test {
        object Unit {
            const val junit4 =  "junit:junit:${Versions.junit4}"
        }
        object Feature {
            const val axEspresso = "androidx.test.espresso:espresso-core:${Versions.axEspresso}"
        }
        object Common {
            const val axJunit4 = "androidx.test.ext:junit:${Versions.axJunit4}"
        }
    }
}