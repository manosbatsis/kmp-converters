package com.github.manosbatsis.kmp.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import java.math.BigDecimal
import com.ionspin.kotlin.bignum.decimal.BigDecimal as KBigDecimal

@ElideTypeConverter(type = KBigDecimal::class, name = "IonspinBigDecimal")
class IonspinBigDecimalSerde : Serde<BigDecimal?, KBigDecimal?> {
    override fun deserialize(value: BigDecimal?): KBigDecimal? {
        return if (value == null) null else KBigDecimal.parseString(value.toPlainString())
    }

    override fun serialize(value: KBigDecimal?): BigDecimal? {
        return if (value == null) null else BigDecimal(value.toStringExpanded())
    }
}
