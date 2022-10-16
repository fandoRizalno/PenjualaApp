package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.lifeCycle(lifecycle_version : String){
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
}