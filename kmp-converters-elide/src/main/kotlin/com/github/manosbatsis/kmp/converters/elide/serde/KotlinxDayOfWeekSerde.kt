package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.DayOfWeek

@ElideTypeConverter(type = DayOfWeek::class, name = "KotlinxDayOfWeek")
class KotlinxDayOfWeekSerde : Serde<Int?, DayOfWeek?> {
    override fun deserialize(value: Int?): DayOfWeek? {
        return if (value == null) null else DayOfWeek.of(value)
    }

    override fun serialize(value: DayOfWeek?): Int? {
        return value?.value
    }
}
