package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxLocalDateTimeIsoStringColumnAdapterTest {

    val value = Clock.System.now().toLocalDateTime(TimeZone.UTC)
    val valueString = "$value"

    @Test
    fun decode() {
        assertEquals(value, KotlinxLocalDateTimeIsoStringColumnAdapter.decode(valueString))
    }

    @Test
    fun encode() {
        assertEquals(valueString, KotlinxLocalDateTimeIsoStringColumnAdapter.encode(value))
    }
}
