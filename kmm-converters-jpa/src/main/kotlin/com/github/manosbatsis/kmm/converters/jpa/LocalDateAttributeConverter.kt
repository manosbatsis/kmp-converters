package com.github.manosbatsis.kmm.converters.jpa

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toKotlinLocalDate
import java.sql.Date
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class LocalDateAttributeConverter : AttributeConverter<LocalDate, Date> {

    override fun convertToDatabaseColumn(attributeData: LocalDate?): Date? {
        return if (attributeData == null) null
        else Date.valueOf("${attributeData.year}-${attributeData.monthNumber}-${attributeData.dayOfMonth}")
    }

    override fun convertToEntityAttribute(columnData: Date?): LocalDate? {
        return columnData?.toLocalDate()?.toKotlinLocalDate()
    }
}
