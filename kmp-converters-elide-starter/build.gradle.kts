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

val elideVersion by System.getProperties()

dependencies {
    api(project(":kmp-converters-elide-autoconfigure"))
    api(project(":kmp-converters-springboot-autoconfigure"))
    implementation("com.yahoo.elide:elide-spring-boot-starter:$elideVersion")
}
