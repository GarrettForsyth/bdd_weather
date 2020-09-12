import com.android.build.gradle.AppExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByName

/**
 * Configuration for the application module.
 */
fun AppExtension.configureLibrary(project: Project) {
    defaultConfig.apply {
        applicationId(ProjectConfiguration.applicationId)
        buildToolsVersion(ProjectConfiguration.buildToolsVersion)
        versionCode(ProjectConfiguration.versionCode)
        versionName(ProjectConfiguration.versionName)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}