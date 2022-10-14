package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxInstantNoNanosColumnAdapterTest {

    private val value = Clock.System.now().let { it.minus(it.nanosecondsOfSecond, DateTimeUnit.NANOSECOND) }
    private val valueConverted = value.toEpochMilliseconds()

    @Test
    fun decode() {
        assertEquals(value, KotlinxInstantNoNanosColumnAdapter.decode(valueConverted))
    }

    @Test
    fun encode() {
        assertEquals(valueConverted, KotlinxInstantNoNanosColumnAdapter.encode(value))
    }
}
