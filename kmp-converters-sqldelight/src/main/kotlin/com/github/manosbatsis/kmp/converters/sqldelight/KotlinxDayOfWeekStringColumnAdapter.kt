package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.DayOfWeek

object KotlinxDayOfWeekStringColumnAdapter : ColumnAdapter<DayOfWeek, String> {
    override fun decode(databaseValue: String) = DayOfWeek.valueOf(databaseValue)
    override fun encode(value: DayOfWeek) = value.name
}
