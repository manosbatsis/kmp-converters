package com.github.manosbatsis.kmp.converters.sqldelight

import com.benasher44.uuid.Uuid
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object Benasher44UuidColumnAdapterTest {
    @Test
    fun decode() {
        val uuid = Uuid.randomUUID()
        assertEquals(uuid, Benasher44UuidColumnAdapter.decode(uuid.toString()))
    }

    @Test
    fun encode() {
        val uuid = Uuid.randomUUID()
        assertEquals(uuid.toString(), Benasher44UuidColumnAdapter.encode(uuid))
    }
}
