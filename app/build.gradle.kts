dependencies {
    testImplementation(project(":core_test"))
    androidTestImplementation(project(":core_android_test"))
    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Compatibility.coreKtx)
    implementation(Libraries.Compatibility.appCompat)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.constraintLayout)
}