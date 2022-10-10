
rootProject.name = "kmm-converters"

include(
    "kmm-converters-elide-autoconfigure",
    "kmm-converters-elide-starter",
    "kmm-converters-elide",
    "kmm-converters-jpa",
    "kmm-converters-springboot-autoconfigure",
    "kmm-converters-springboot-starter"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

apply(from = "./buildSrc/repositories.settings.gradle.kts")

@Suppress("UnstableApiUsage") // Central declaration of repositories is an incubating feature
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
}
