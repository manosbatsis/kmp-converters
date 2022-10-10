package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.LocalDate

@ElideTypeConverter(type = LocalDate::class, name = "KotlinxLocalDate")
class KotlinxLocalDateSerde : Serde<String?, LocalDate?> {
    override fun deserialize(value: String?): LocalDate? {
        return if (value == null) null else LocalDate.parse(value)
    }

    override fun serialize(value: LocalDate?): String? {
        return value?.toString()
    }
}
