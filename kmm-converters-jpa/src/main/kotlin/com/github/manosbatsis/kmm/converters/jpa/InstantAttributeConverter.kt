package com.github.manosbatsis.kmm.converters.jpa

import kotlinx.datetime.Instant
import java.sql.Timestamp
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class InstantAttributeConverter : AttributeConverter<Instant?, Timestamp?> {

    override fun convertToDatabaseColumn(attributeData: Instant?): Timestamp? {
        return attributeData?.let { Timestamp(it.toEpochMilliseconds()) }
    }

    override fun convertToEntityAttribute(columnData: Timestamp?): Instant? {
        return columnData?.let { Instant.fromEpochMilliseconds(it.time) }
    }
}
