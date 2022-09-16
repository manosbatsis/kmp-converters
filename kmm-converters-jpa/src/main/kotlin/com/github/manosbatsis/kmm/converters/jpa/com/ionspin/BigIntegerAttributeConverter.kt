package com.github.manosbatsis.kmm.converters.jpa.com.ionspin

import java.math.BigInteger
import javax.persistence.AttributeConverter
import com.ionspin.kotlin.bignum.integer.BigInteger as KBigInteger
import javax.persistence.Converter

@Converter(autoApply = false)
class BigIntegerAttributeConverter : AttributeConverter<KBigInteger?, BigInteger?> {
    override fun convertToDatabaseColumn(attribute: KBigInteger?): BigInteger? {
        return if (attribute == null) null else BigInteger(attribute.toString())
    }

    override fun convertToEntityAttribute(dbData: BigInteger?): KBigInteger? {
        return if (dbData == null) null else KBigInteger.parseString(dbData.toString())
    }
}
