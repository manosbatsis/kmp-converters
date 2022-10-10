package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDate

object KotlinxLocalDateIsoStringColumnAdapter : ColumnAdapter<LocalDate, String> {
    override fun decode(databaseValue: String) = LocalDate.parse(databaseValue)

    override fun encode(value: LocalDate) = value.toString()
}
