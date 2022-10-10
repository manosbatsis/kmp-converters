package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.squareup.sqldelight.ColumnAdapter

object IonspinBigDecimalStringColumnAdapter : ColumnAdapter<BigDecimal, String> {
    override fun decode(databaseValue: String) = BigDecimal.parseString(databaseValue)

    override fun encode(value: BigDecimal) = value.toStringExpanded()
}
