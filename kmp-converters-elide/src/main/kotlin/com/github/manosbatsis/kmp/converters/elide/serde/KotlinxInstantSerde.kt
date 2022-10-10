package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.Instant

/** [Serde] for [Instant] objects, based on Epoch milliseconds */
@ElideTypeConverter(type = Instant::class, name = "KotlinxInstant")
class KotlinxInstantSerde : Serde<Long?, Instant?> {
    override fun deserialize(value: Long?): Instant? {
        return if (value == null) null else Instant.fromEpochMilliseconds(value)
    }

    override fun serialize(value: Instant?): Long? {
        return if (value == null) null else value.toEpochMilliseconds()
    }
}
