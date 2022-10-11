package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.Clock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxInstantStringColumnAdapterTest {

    val value = Clock.System.now()
    val valueLEncoded = value.toString()

    @Test
    fun decode() {
        assertEquals(0, KotlinxInstantStringColumnAdapter.decode(valueLEncoded).compareTo(value))
    }

    @Test
    fun encode() {
        assertEquals(valueLEncoded, KotlinxInstantStringColumnAdapter.encode(value))
    }
}
