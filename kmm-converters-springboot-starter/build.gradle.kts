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

    api(project(":kmm-converters-springboot-autoconfigure"))

    "jakartaPersistenceSupportImplementation"(project(":kmm-converters-springboot-autoconfigure")) {
        capabilities {
            requireCapability("$group:kmm-converters-springboot-autoconfigure-jakarta-persistence-support")
        }
    }
    "javaxPersistenceSupportImplementation"(project(":kmm-converters-springboot-autoconfigure")) {
        capabilities {
            requireCapability("$group:kmm-converters-springboot-autoconfigure-javax-persistence-support")
        }
    }
}
