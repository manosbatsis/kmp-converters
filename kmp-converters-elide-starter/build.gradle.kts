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
    implementation(project(":kmp-converters-springboot-starter"))
    implementation("com.yahoo.elide:elide-spring-boot-starter:$elideVersion")
}
