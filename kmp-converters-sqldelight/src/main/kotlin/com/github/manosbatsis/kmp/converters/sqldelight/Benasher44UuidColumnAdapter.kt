package com.github.manosbatsis.kmp.converters.sqldelight

import com.benasher44.uuid.Uuid
import com.squareup.sqldelight.ColumnAdapter

object Benasher44UuidColumnAdapter : ColumnAdapter<Uuid, String> {
    override fun decode(databaseValue: String) = databaseValue.let(Uuid::fromString)

    override fun encode(value: Uuid) = value.toString()
}
