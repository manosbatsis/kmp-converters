package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.Month

object KotlinxMonthStringColumnAdapter : ColumnAdapter<Month, Int> {
    override fun decode(databaseValue: Int) = Month.of(databaseValue)

    override fun encode(value: Month) = value.value
}
