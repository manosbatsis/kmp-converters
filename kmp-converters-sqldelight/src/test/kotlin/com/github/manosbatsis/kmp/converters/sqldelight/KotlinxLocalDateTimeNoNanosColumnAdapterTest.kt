package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxLocalDateTimeNoNanosColumnAdapterTest {

    private val value = Clock.System.now().let { it.minus(it.nanosecondsOfSecond, DateTimeUnit.NANOSECOND) }
        .toLocalDateTime(TimeZone.UTC)
    private val valueConverted = value.toInstant(TimeZone.UTC).toEpochMilliseconds()

    @Test
    fun decode() {
        assertEquals(value, KotlinxLocalDateTimeNoNanosColumnAdapter.decode(valueConverted))
    }

    @Test
    fun encode() {
        assertEquals(valueConverted, KotlinxLocalDateTimeNoNanosColumnAdapter.encode(value))
    }
}
