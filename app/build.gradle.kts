dependencies {
    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Compatibility.coreKtx)
    implementation(Libraries.Compatibility.appCompat)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.constraintLayout)
    testImplementation(Libraries.Test.Unit.junit4)
    androidTestImplementation(Libraries.Test.Feature.axEspresso)
    androidTestImplementation(Libraries.Test.Common.axJunit4)
}