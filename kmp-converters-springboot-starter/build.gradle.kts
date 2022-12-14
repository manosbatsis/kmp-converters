plugins {
    buildsrc.convention.`kotlin-jvm-spring`
    buildsrc.convention.`publish-jvm`
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}
tasks.named<Jar>("jar") {
    enabled = true
}

val jakartaPersistenceVersion by System.getProperties()
val springBootVersion: String by System.getProperties()

dependencies {
    api(project(":kmp-converters-springboot-autoconfigure"))
}
