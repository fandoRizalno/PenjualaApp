package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidX(){
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.5.0")
    implementation("androidx.annotation:annotation:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

}
