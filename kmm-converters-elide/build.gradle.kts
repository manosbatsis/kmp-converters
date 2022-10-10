plugins {
    buildsrc.convention.`kotlin-jvm`
    buildsrc.convention.`publish-jvm`
}

val kotlinxDatetimeVersion by System.getProperties()
val bignumVersion by System.getProperties()
val uuidVersion by System.getProperties()
val elideVersion by System.getProperties()

dependencies {
    implementation("com.yahoo.elide:elide-core:$elideVersion")

    compileOnly("com.benasher44:uuid:$uuidVersion")
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    compileOnly("com.ionspin.kotlin:bignum:$bignumVersion")
}
