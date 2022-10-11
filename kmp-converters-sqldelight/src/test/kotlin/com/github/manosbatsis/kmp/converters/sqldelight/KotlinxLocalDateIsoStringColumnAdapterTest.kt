package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.toLocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxLocalDateIsoStringColumnAdapterTest {

    val value = Clock.System.now().toLocalDateTime(UTC).date
    val valueString = "$value"

    @Test
    fun decode() {
        assertEquals(value, KotlinxLocalDateIsoStringColumnAdapter.decode(valueString))
    }

    @Test
    fun encode() {
        assertEquals(valueString, KotlinxLocalDateIsoStringColumnAdapter.encode(value))
    }
}
