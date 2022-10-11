package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.DayOfWeek
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object KotlinxDayOfWeekStringColumnAdapterTest {

    val monday = DayOfWeek.MONDAY
    val mondayString = monday.name

    @Test
    fun decode() {
        assertEquals(monday, KotlinxDayOfWeekStringColumnAdapter.decode(mondayString))
    }

    @Test
    fun encode() {
        assertEquals(mondayString, KotlinxDayOfWeekStringColumnAdapter.encode(monday))
    }
}
