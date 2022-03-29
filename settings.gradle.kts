dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "RickAndMortyArchitecture"
include(":app")
include(":data")
include(":common")
enableFeaturePreview("VERSION_CATALOGS")
