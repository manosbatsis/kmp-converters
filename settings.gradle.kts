
rootProject.name = "kmp-converters"

include(
    "kmp-converters-elide-autoconfigure",
    "kmp-converters-elide-starter",
    "kmp-converters-elide",
    "kmp-converters-jpa",
    "kmp-converters-springboot-autoconfigure",
    "kmp-converters-springboot-starter",
    "kmp-converters-sqldelight",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

apply(from = "./buildSrc/repositories.settings.gradle.kts")

@Suppress("UnstableApiUsage") // Central declaration of repositories is an incubating feature
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
}
