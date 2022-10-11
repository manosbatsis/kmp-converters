plugins {
    buildsrc.convention.base
    buildsrc.convention.`kotlin-jvm`
    buildsrc.convention.`publish-jvm`
    id("io.github.gradle-nexus.publish-plugin")
}

@Suppress("PropertyName")
val release_version: String by project
version = release_version

tasks.dokkaHtmlMultiModule.configure {
    includes.from("README.md")
    outputDirectory.set(buildDir.resolve("docs/apidoc"))
}

nexusPublishing {
    repositories {
        sonatype()
    }
}

subprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
        // set JVM arguments for the test JVM(s)
        jvmArgs("-Xmx2048m")
    }
}

tasks.wrapper {
    gradleVersion = "7.5"
    distributionType = Wrapper.DistributionType.ALL
}
