pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Budea_Eduard_ActivitateDAM2026"
include(":app")
include(":app:seminar02_2026")
include(":app:seminar04_2026")
include(":app:pregatire_test")
include(":app:rezolvare_singur")
include(":app:problema1_grup")
include(":app:poza3")
include(":app:pb2_grup")
include(":app:gem")
include(":app:gem2")
include(":app:gem3")
include(":app:gem4")
include(":app:developer")
