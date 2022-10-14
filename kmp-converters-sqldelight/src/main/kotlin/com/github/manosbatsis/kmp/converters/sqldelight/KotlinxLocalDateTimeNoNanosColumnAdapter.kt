package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.*

object KotlinxLocalDateTimeNoNanosColumnAdapter : ColumnAdapter<LocalDateTime, Long> {
    override fun decode(databaseValue: Long) = Instant
        .fromEpochMilliseconds(databaseValue)
        .toLocalDateTime(TimeZone.UTC)

    override fun encode(value: LocalDateTime) = value.toInstant(TimeZone.UTC).toEpochMilliseconds()
}
