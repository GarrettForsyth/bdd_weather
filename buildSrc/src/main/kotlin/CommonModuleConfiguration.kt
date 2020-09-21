import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion

/**
 * Configuration common between
 *      AppExtension
 *      LibraryExtension
 *      TestExtension
 *      FeatureExtension
 */
fun BaseExtension.configureCommon() {
    setCompileSdkVersion(ProjectConfiguration.compiledSdkVersion)
    defaultConfig.apply {
        minSdkVersion(ProjectConfiguration.minSdkVersion)
        targetSdkVersion(ProjectConfiguration.targetSdkVersion)
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    flavorDimensions("default")
    productFlavors {
        create("dev") {
            resConfigs("en", "xxhdpi")
        }
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


