// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    // Plugins common to all modules
    apply {
        plugin(if (name == "app") "com.android.application" else "com.android.library" )
        plugin("kotlin-android") // All modules are kotlin modules
        plugin("my-configuration-plugin")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}