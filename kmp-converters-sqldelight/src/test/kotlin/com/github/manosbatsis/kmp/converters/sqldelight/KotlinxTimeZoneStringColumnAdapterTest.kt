package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.TimeZone
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxTimeZoneStringColumnAdapterTest {

    val value = TimeZone.currentSystemDefault()
    val valueEncoded = value.id

    @Test
    fun decode() {
        assertEquals(value, KotlinxTimeZoneStringColumnAdapter.decode(valueEncoded))
    }

    @Test
    fun encode() {
        assertEquals(valueEncoded, KotlinxTimeZoneStringColumnAdapter.encode(value))
    }
}
