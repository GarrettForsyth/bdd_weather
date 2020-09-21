android.defaultConfig.targetSdk = ProjectConfiguration.targetSdkVersion
dependencies {
    implementation(project(":app"))
    testImplementation(project(":core_test"))
    androidTestImplementation(project(":core_android_test"))
    androidTestImplementation(Libraries.Test.Common.mockWebServer)
}