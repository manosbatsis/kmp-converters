package com.github.manosbatsis.kmp.converters.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.Instant

object KotlinxInstantColumnAdapter : ColumnAdapter<Instant, Long> {
    override fun decode(databaseValue: Long) = databaseValue.let(Instant.Companion::fromEpochMilliseconds)

    override fun encode(value: Instant) = value.toEpochMilliseconds()
}
