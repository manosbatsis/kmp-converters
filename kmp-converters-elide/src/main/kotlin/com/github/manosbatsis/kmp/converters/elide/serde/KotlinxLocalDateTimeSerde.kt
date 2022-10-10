package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.LocalDateTime

@ElideTypeConverter(type = LocalDateTime::class, name = "KotlinxLocalDateTime")
class KotlinxLocalDateTimeSerde : Serde<String?, LocalDateTime?> {
    override fun deserialize(value: String?): LocalDateTime? {
        return if (value == null) null else LocalDateTime.parse(value)
    }

    override fun serialize(value: LocalDateTime?): String? {
        return value?.toString()
    }
}
