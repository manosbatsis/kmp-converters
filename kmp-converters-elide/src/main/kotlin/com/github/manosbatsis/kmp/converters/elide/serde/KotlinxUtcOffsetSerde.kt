package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.UtcOffset
import java.time.ZoneOffset

@ElideTypeConverter(type = UtcOffset::class, name = "KotlinxUtcOffset")
class KotlinxUtcOffsetSerde : Serde<Int?, UtcOffset?> {
    override fun deserialize(value: Int?): UtcOffset? {
        return if (value == null) null else UtcOffset(ZoneOffset.ofTotalSeconds(value))
    }

    override fun serialize(value: UtcOffset?): Int? {
        return value?.totalSeconds
    }
}
