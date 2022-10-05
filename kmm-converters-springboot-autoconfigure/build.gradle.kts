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

java {
    registerFeature("jakartaPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
        capability("${project.group}", project.name + "-javax-persistence-support", "2.2")
    }
    registerFeature("javaxPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
        capability("${project.group}", project.name + "-jakarta-persistence-support", "$jakartaPersistenceVersion")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")

    implementation("com.benasher44:uuid:$uuidVersion")
    implementation("com.ionspin.kotlin:bignum:$bignumVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")

    "jakartaPersistenceSupportImplementation"(project(":kmm-converters-jpa")) {
        capabilities {
            requireCapability("$group:kmm-converters-jpa-jakarta-persistence-support")
        }
    }
    "javaxPersistenceSupportImplementation"(project(":kmm-converters-jpa")) {
        capabilities {
            requireCapability("$group:kmm-converters-jpa-javax-persistence-support")
        }
    }
}
