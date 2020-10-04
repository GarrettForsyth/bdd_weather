dependencies {
    implementation(project(":app"))
    testImplementation(project(":core_test"))
    androidTestImplementation(project(":core_android_test"))

    annotationProcessor(Libraries.Room.compiler)

    androidTestImplementation(Libraries.Test.Common.mockWebServer)
    testRuntimeOnly(Libraries.Test.Unit.junit5Engine)


}