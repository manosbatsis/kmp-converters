package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.TimeZone

object KotlinxTimeZoneStringColumnAdapter : ColumnAdapter<TimeZone, String> {
    override fun decode(databaseValue: String) = TimeZone.of(databaseValue)

    override fun encode(value: TimeZone) = value.toString()
}
