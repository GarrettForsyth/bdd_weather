plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
}

gradlePlugin {
    plugins {
        create("MyPlugins") {
            id = "my-configuration-plugin"
            implementationClass = "MyConfigurationPlugin"
        }
    }
}

// TODO: Keep these dependencies updated with latest version.
dependencies {
    implementation("com.android.tools.build:gradle:4.2.0-alpha11")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
}

kotlinDslPluginOptions{
    experimentalWarning.set(false)
}