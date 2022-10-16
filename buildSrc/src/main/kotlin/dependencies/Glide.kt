package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.glide(glide_version: String) {
    implementation("com.github.bumptech.glide:glide:$glide_version")
    annotationProcessor("com.github.bumptech.glide:compiler:$glide_version")
}
