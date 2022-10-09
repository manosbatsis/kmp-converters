package com.github.manosbatsis.kmm.converters.jpa.com.ionspin

import java.math.BigDecimal
import javax.persistence.AttributeConverter
import com.ionspin.kotlin.bignum.decimal.BigDecimal as KBigDecimal
import javax.persistence.Converter

@Converter(autoApply = true)
class BigDecimalAttributeConverter : AttributeConverter<KBigDecimal?, BigDecimal?> {
    override fun convertToDatabaseColumn(attribute: KBigDecimal?): BigDecimal? {
        return if (attribute == null) null else BigDecimal(attribute.toStringExpanded())
    }

    override fun convertToEntityAttribute(dbData: BigDecimal?): KBigDecimal? {
        return if (dbData == null) null else KBigDecimal.parseString(dbData.toPlainString())
    }
}
