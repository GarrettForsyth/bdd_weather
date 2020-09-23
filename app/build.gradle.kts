android.dynamicFeatures.addAll(listOf(":daily_weather_feature"))
dependencies {
    testImplementation(project(":core_test"))

    implementation(Libraries.Kotlin.stdLib)

    implementation(Libraries.Compatibility.playCore)
    implementation(Libraries.Compatibility.playCoreKtx)

    api(Libraries.Compatibility.appCompat)
    implementation(Libraries.Compatibility.coreKtx)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.constraintLayout)
}