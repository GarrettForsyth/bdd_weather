import com.android.build.api.dsl.DynamicFeatureExtension
import org.gradle.api.JavaVersion

fun DynamicFeatureExtension<*,*,*,*,*>.configure() {

    compileSdk = ProjectConfiguration.compiledSdkVersion
    defaultConfig.apply {
        minSdk = ProjectConfiguration.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions.add("default")
    productFlavors.create("dev") {
        resourceConfigurations.add("en")
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
