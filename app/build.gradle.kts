android.dynamicFeatures.addAll(listOf(":daily_weather_feature"))
dependencies {
    testImplementation(project(":core_test"))

    implementation(Libraries.Kotlin.stdLib)

    implementation(Libraries.Compatibility.playCore)
    implementation(Libraries.Compatibility.playCoreKtx)

    api(Libraries.Compatibility.appCompat)
    api(Libraries.Compatibility.coreKtx)
    api(Libraries.UI.material)
    api(Libraries.UI.constraintLayout)
    api(Libraries.Compatibility.navKtx)
    api(Libraries.Compatibility.navFeatureSupport)
    api(Libraries.UI.constraintLayout)

    api(Libraries.LifeCycle.viewmodel)
    api(Libraries.LifeCycle.livedata)
    api(Libraries.LifeCycle.lifecycles)
    api(Libraries.LifeCycle.saveState)
    api(Libraries.LifeCycle.compiler)

    api(Libraries.Network.retrofit)

    api(Libraries.Room.room)
    api(Libraries.Room.ktx)

    // https://issuetracker.google.com/issues/128612536
    debugApi(Libraries.Test.Feature.fragment) {
        exclude(group = "androidx.test", module = "core")
    }
}