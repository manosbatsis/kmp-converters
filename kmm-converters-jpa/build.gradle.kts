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
    registerFeature("benasher44UuidSupport") {
        usingSourceSet(sourceSets["main"])
    }
    registerFeature("kotlinxDatetimeSupport") {
        usingSourceSet(sourceSets["main"])
    }
    registerFeature("ionspinBignumSupport") {
        usingSourceSet(sourceSets["main"])
    }
    registerFeature("jakartaPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
    }
    registerFeature("javaxPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
    }
}

dependencies {
    "jakartaPersistenceSupportImplementation"("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
    "javaxPersistenceSupportImplementation"("javax.persistence:javax.persistence-api:$javaxPersistenceVersion")
    "benasher44UuidSupportImplementation"("com.benasher44:uuid:$uuidVersion")
    "kotlinxDatetimeSupportImplementation"("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    "ionspinBignumSupportImplementation"("com.ionspin.kotlin:bignum:$bignumVersion")
}
