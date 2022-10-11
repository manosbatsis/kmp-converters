package com.github.manosbatsis.kmp.converters.sqldelight

import kotlinx.datetime.DayOfWeek
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

object KotlinxDayOfWeekColumnAdapterTest {

    val monday = DayOfWeek.MONDAY
    val mondayInt = monday.value

    @Test
    fun decode() {
        Assertions.assertEquals(monday, KotlinxDayOfWeekColumnAdapter.decode(mondayInt))
    }

    @Test
    fun encode() {
        Assertions.assertEquals(mondayInt, KotlinxDayOfWeekColumnAdapter.encode(monday))
    }
}
