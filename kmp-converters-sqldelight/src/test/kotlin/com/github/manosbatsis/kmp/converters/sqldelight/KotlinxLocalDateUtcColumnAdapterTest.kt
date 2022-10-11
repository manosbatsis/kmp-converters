package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxLocalDateUtcColumnAdapterTest {

    val value = Clock.System.now()
        .toLocalDateTime(TimeZone.UTC).date
    val valueEncoded = value.atStartOfDayIn(TimeZone.UTC).toEpochMilliseconds()

    @Test
    fun decode() {
        assertEquals(value, KotlinxLocalDateUtcColumnAdapter.decode(valueEncoded))
    }

    @Test
    fun encode() {
        assertEquals(valueEncoded, KotlinxLocalDateUtcColumnAdapter.encode(value))
    }
}
