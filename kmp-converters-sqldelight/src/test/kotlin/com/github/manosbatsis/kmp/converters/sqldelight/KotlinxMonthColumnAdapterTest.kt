package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.Month
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxMonthColumnAdapterTest {

    val value = Month.SEPTEMBER
    val valueEncoded = value.value

    @Test
    fun decode() {
        assertEquals(value, KotlinxMonthColumnAdapter.decode(valueEncoded))
    }

    @Test
    fun encode() {
        assertEquals(valueEncoded, KotlinxMonthColumnAdapter.encode(value))
    }
}
