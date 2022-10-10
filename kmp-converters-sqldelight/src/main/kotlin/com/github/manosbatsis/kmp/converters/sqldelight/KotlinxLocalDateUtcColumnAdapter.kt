package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.*

object KotlinxLocalDateUtcColumnAdapter : ColumnAdapter<LocalDate, Long> {
    override fun decode(databaseValue: Long) = Instant.fromEpochMilliseconds(databaseValue)
        .toLocalDateTime(TimeZone.UTC).date

    override fun encode(value: LocalDate) = value.atStartOfDayIn(TimeZone.UTC).toEpochMilliseconds()
}
