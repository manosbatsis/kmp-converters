plugins {
    buildsrc.convention.`kotlin-jvm`
    buildsrc.convention.`publish-jvm`
}

val kotlinxDatetimeVersion by System.getProperties()
val bignumVersion by System.getProperties()
val uuidVersion by System.getProperties()

val jakartaPersistenceVersion by System.getProperties()
val javaxPersistenceVersion by System.getProperties()

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
    "jakartaPersistenceSupportImplementation"("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
    "javaxPersistenceSupportImplementation"("javax.persistence:javax.persistence-api:$javaxPersistenceVersion")
    compileOnly("com.benasher44:uuid:$uuidVersion")
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    compileOnly("com.ionspin.kotlin:bignum:$bignumVersion")
}
