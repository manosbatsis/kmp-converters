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

val springBootVersion: String by System.getProperties()

dependencies {
    api(project(":kmm-converters-elide"))
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
}
