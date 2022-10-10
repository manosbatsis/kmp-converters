plugins {
    buildsrc.convention.`kotlin-jvm`
    buildsrc.convention.`publish-jvm`
}

val kotlinxDatetimeVersion by System.getProperties()
val bignumVersion by System.getProperties()
val uuidVersion by System.getProperties()
val sqldelightVersion by System.getProperties()

dependencies {
    implementation("com.squareup.sqldelight:coroutines-extensions:$sqldelightVersion")

    compileOnly("com.benasher44:uuid:$uuidVersion")
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
    compileOnly("com.ionspin.kotlin:bignum:$bignumVersion")
}
