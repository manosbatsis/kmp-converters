package com.github.manosbatsis.kmm.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import kotlinx.datetime.TimeZone

@ElideTypeConverter(type = TimeZone::class, name = "KotlinxTimeZone")
class KotlinxTimeZoneSerde : Serde<String?, TimeZone?> {
  override fun deserialize(value: String?): TimeZone? {
    return if (value == null) null else TimeZone.of(value)
  }

  override fun serialize(value: TimeZone?): String? {
    return value?.toString()
  }
}
