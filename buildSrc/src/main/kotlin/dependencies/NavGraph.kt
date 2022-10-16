package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.navGraph(nav_version: String){

        implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
        implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")
}