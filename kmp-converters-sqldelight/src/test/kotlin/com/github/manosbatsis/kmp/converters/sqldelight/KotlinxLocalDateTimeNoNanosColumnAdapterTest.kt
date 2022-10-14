package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxLocalDateTimeNoNanosColumnAdapterTest {

    private val valueInstant = Clock.System.now()
    private val value = valueInstant.let { it.minus(it.nanosecondsOfSecond, DateTimeUnit.NANOSECOND) }
        .toLocalDateTime(TimeZone.UTC)
    private val valueInstantConverted = value.toInstant(TimeZone.UTC).toEpochMilliseconds()
    private val valueConverted = value.toInstant(TimeZone.UTC).toEpochMilliseconds()

    @Test
    fun decode() {
        assertEquals(value, KotlinxLocalDateTimeNoNanosColumnAdapter.decode(valueConverted))
        assertEquals(value, KotlinxLocalDateTimeNoNanosColumnAdapter.decode(valueInstantConverted))
    }

    @Test
    fun encode() {
        assertEquals(valueConverted, KotlinxLocalDateTimeNoNanosColumnAdapter.encode(value))
        assertEquals(valueInstantConverted, KotlinxLocalDateTimeNoNanosColumnAdapter.encode(value))
    }
}
