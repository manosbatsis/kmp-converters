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
        capability(project.name, "benasher44-uuid-support", "$uuidVersion")
    }
    registerFeature("kotlinxDatetimeSupport") {
        usingSourceSet(sourceSets["main"])
        capability(project.name, "kotlinx-datetime-support", "$kotlinxDatetimeVersion")
    }
    registerFeature("ionspinBignumSupport") {
        usingSourceSet(sourceSets["main"])
        capability(project.name, "ionspin-bgnum-support", "$bignumVersion")
    }
    registerFeature("jakartaPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
        capability(project.name, "javax-persistence-support", "2.2")
        capability(project.name, "jakarta-persistence-support", "$jakartaPersistenceVersion")
    }
    registerFeature("javaxPersistenceSupport") {
        usingSourceSet(sourceSets["main"])
        capability(project.name, "javax-persistence-support", "2.2")
        capability(project.name, "javax-persistence-support", "$javaxPersistenceVersion")
    }
}

dependencies {
    "jakartaPersistenceSupportApi"("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
    "javaxPersistenceSupportApi"("javax.persistence:javax.persistence-api:$javaxPersistenceVersion")
    "benasher44UuidSupportApi"("com.benasher44:uuid:$uuidVersion")
    "kotlinxDatetimeSupportApi"("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    "ionspinBignumSupportApi"("com.ionspin.kotlin:bignum:$bignumVersion")
}
