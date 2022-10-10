package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDateTime

object KotlinxLocalDateTimeIsoStringColumnAdapter : ColumnAdapter<LocalDateTime, String> {
    override fun decode(databaseValue: String) = LocalDateTime.parse(databaseValue)

    override fun encode(value: LocalDateTime) = value.toString()
}
