package com.github.manosbatsis.kmp.converters.elide.serde

import com.benasher44.uuid.Uuid
import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde

@ElideTypeConverter(type = Uuid::class, name = "Benasher44Uuid")
class Benasher44UuidSerde : Serde<String?, Uuid?> {
    override fun deserialize(value: String?): Uuid? {
        return if (value == null) null else Uuid.fromString(value)
    }

    override fun serialize(value: Uuid?): String? {
        return value?.toString()
    }
}
