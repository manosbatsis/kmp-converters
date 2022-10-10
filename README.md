# KMM Converters

Support for common KMM types in popular JVM frameworks or APIs 
like JPA, Spring Boot amd Elide.

Supported KMM libraries:

- [benasher44/uuid](https://github.com/benasher44/uuid)
- [ionspin/kotlin-multiplatform-bignum](https://github.com/ionspin/kotlin-multiplatform-bignum)
- [Kotlin/kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime)

## Gradle Setup

Add the following repositories:

```kotlin
maven("https://oss.sonatype.org/content/repositories/releases/")
// For snapshots, optional
maven("https://oss.sonatype.org/content/repositories/snapshots/")
```

## For Plain JPA

The following Gradle dependency adds [JPA Attribute Converters](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/attributeconverter) for supported KMM types:

```kotlin
implementation("com.github.manosbatsis.kmm.converters:kmm-converters-jpa:$kmmConvertersVersion")
```

The converters can be found in the `com.github.manosbatsis.kmm.converters.jpa` 
[package](https://github.com/manosbatsis/kmm-converters/tree/master/kmm-converters-jpa/src/main/kotlin/com/github/manosbatsis/kmm/converters/jpa).

Note that JPA does not support conversion of `@Id` annotated members. If you need to use one of the supported KMM types 
as an identifier, you can work around the JPA spec limitation by:

- Wrapping the converted type within an `Embeddable` type
- Use the wrapper as the id type
- Annotate the id `@EmbeddedId`

For example, suppose you want to use `com.benasher44.uuid.Uuid` as an identifier:

```kotlin
@Embeddable
class UuidId {
    @Column(name = "ID", nullable = false)
    @Convert(converter = UuidAttributeConverter::class)
    private var id: Uuid? = null
}

// In your entity
class MyEntity(
    @EmbeddedId
    private var pk: UuidId? = null
)
```

## For Spring Boot

The following starter configures the JPA Attribute Converters described above:

```kotlin
implementation("com.github.manosbatsis.kmm.converters:kmm-converters-springboot-starter:$kmmConvertersVersion")
```

## For Elide Standalone

The following dependencies add JPA Attribute Converters (as described above)
and [Serde](https://elide.io/pages/guide/v5/09-clientapis.html#type-coercion) implementations
for supported KMM types:

```kotlin
implementation("com.github.manosbatsis.kmm.converters:kmm-converters-jpa:$kmmConvertersVersion")
implementation("com.github.manosbatsis.kmm.converters:kmm-converters-elide:$kmmConvertersVersion")
```

## For Elide with Spring Boot

The following starter configures both JPA and Serde converters described in previous sections:

```kotlin
implementation("com.github.manosbatsis.kmm.converters:kmm-converters-elide-starter:$kmmConvertersVersion")
```
