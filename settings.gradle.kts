pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CursoAndroidCompose"
include(":app")
include(":00_basicslayout")
include(":00_kotlinfundamentals")
include(":01_dicerollerapp")
include(":02_lemonadeapp")
include(":03_artspaceapp")
