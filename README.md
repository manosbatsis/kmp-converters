# Kotlin Multiplatform Converters [![Maven Central](https://img.shields.io/maven-central/v/com.github.manosbatsis.kmp.converters/kmp-converters-springboot-starter.svg)](https://repo1.maven.org/maven2/com/github/manosbatsis/kmp/converters/kmp-converters-springboot-starter)

Playground for support of common KMP types in popular JVM frameworks or APIs, 
like JPA, Spring Boot, Elide and SQLDelight.

##### This repo is experimental and largely untested. Use at your own risk. Contributions welcome.

Supported KMP libraries:

- [benasher44/uuid](https://github.com/benasher44/uuid)
- [ionspin/kotlin-multiplatform-bignum](https://github.com/ionspin/kotlin-multiplatform-bignum)
- [Kotlin/kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime)

## Gradle Setup

Releases are available from Maven Central. Snapshots are available from Sonatype's OSS repository:

```kotlin
// For snapshots, optional
maven("https://oss.sonatype.org/content/repositories/snapshots/")
```

## For Plain JPA

The following Gradle dependency adds [JPA Attribute Converters](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/attributeconverter) for supported KMP types:

```kotlin
implementation("com.github.manosbatsis.kmp.converters:kmp-converters-jpa:$kmpConvertersVersion")
```

The converters can be found in the `com.github.manosbatsis.kmp.converters.jpa`
[package](https://github.com/manosbatsis/kmp-converters/tree/master/kmp-converters-jpa/src/main/kotlin/com/github/manosbatsis/kmp/converters/jpa).

### JPA Identifiers

Note that JPA does not apply Attribute Converters on `@Id` annotated members. If you need to use one of the supported KMP types
as an identifier, you can work around the JPA spec limitation in three steps:

1. Wrap the converted type within an `Embeddable` type
2. Use the wrapper as the id type
3. Annotate the id `@EmbeddedId`

For example, suppose you want to use `com.benasher44.uuid.Uuid` as an identifier:

```kotlin
@Embeddable
class UuidId {
    @Column(name = "ID", nullable = false)
    @Convert(converter = UuidAttributeConverter::class)
    private var id: Uuid? = null
}

// In your entity
@Entity
class MyEntity(
    @EmbeddedId
    private var pk: UuidId? = null
)
```

## For Spring Boot

The following starter configures the JPA Attribute Converters described above:

```kotlin
implementation("com.github.manosbatsis.kmp.converters:kmp-converters-springboot-starter:$kmpConvertersVersion")
```

## For Elide Standalone

The following dependencies add JPA Attribute Converters (as described above)
and [Serde](https://elide.io/pages/guide/v5/09-clientapis.html#type-coercion) implementations
for supported KMP types:

```kotlin
implementation("com.github.manosbatsis.kmp.converters:kmp-converters-jpa:$kmpConvertersVersion")
implementation("com.github.manosbatsis.kmp.converters:kmp-converters-elide:$kmpConvertersVersion")
```

## For Elide with Spring Boot

The following starter configures both JPA and Serde converters described in previous sections:

```kotlin
implementation("com.github.manosbatsis.kmp.converters:kmp-converters-elide-starter:$kmpConvertersVersion")
```
