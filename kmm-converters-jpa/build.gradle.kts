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
        capability(project.name, "kotlinx-satetime-support", "$kotlinxDatetimeVersion")
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
/*

systemProp.javaxPersistenceVersion=2.2
systemProp.jakartaPersistenceVersion=2.2.3
*/

dependencies {
    "jakartaPersistenceSupportImplementation"("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
    "javaxPersistenceSupportImplementation"("javax.persistence:javax.persistence-api:$javaxPersistenceVersion")
    "benasher44UuidSupportImplementation"("com.benasher44:uuid:$uuidVersion")
    "kotlinxDatetimeSupportImplementation"("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    "ionspinBignumSupportImplementation"("com.ionspin.kotlin:bignum:$bignumVersion")
}
