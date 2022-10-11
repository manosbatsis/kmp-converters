package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.Instant

object KotlinxInstantStringColumnAdapter : ColumnAdapter<Instant, String> {
    override fun decode(databaseValue: String) = Instant.parse(databaseValue)
    override fun encode(value: Instant): String = value.toString()
}
