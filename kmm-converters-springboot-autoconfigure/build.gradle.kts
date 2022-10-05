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

val kotlinxDatetimeVersion by System.getProperties()
val bignumVersion by System.getProperties()
val uuidVersion by System.getProperties()

val jakartaPersistenceVersion by System.getProperties()
val javaxPersistenceVersion by System.getProperties()
val springBootVersion: String by System.getProperties()

dependencies {
    implementation(project(":kmm-converters-jpa"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")

    compileOnly("com.benasher44:uuid:$uuidVersion")
    compileOnly("com.ionspin.kotlin:bignum:$bignumVersion")
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
}
