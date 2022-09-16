package com.github.manosbatsis.kmm.converters.jpa.com.benasher44

import com.benasher44.uuid.Uuid
import java.util.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = false)
class UuidAttributeConverter : AttributeConverter<Uuid?, UUID?> {
    override fun convertToDatabaseColumn(attribute: Uuid?): UUID? {
        return if (attribute == null) null else UUID.fromString(attribute.toString())
    }

    override fun convertToEntityAttribute(dbData: UUID?): Uuid? {
        return if (dbData == null) null else Uuid.fromString(dbData.toString())
    }
}
