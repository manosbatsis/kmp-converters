package com.github.manosbatsis.kmm.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.Month

@ElideTypeConverter(type = Month::class, name = "KotlinxMonth")
class KotlinxMonthSerde : Serde<Short?, Month?> {
    override fun deserialize(value: Short?): Month? {
        return if (value == null) null else Month.of(value.toInt())
    }

    override fun serialize(value: Month?): Short? {
        return value?.value?.toShort()
    }
}
