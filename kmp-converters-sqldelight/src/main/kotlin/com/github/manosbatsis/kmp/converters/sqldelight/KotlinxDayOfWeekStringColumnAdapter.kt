package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.*

object KotlinxDayOfWeekStringColumnAdapter : ColumnAdapter<DayOfWeek, Int> {
    override fun decode(databaseValue: Int) = DayOfWeek.of(databaseValue)
    override fun encode(value: DayOfWeek) = value.value
}
