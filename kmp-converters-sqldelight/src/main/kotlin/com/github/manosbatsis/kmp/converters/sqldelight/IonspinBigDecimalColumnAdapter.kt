package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.squareup.sqldelight.ColumnAdapter

object IonspinBigDecimalColumnAdapter : ColumnAdapter<BigDecimal, Double> {
    override fun decode(databaseValue: Double) = BigDecimal.fromDouble(databaseValue)

    override fun encode(value: BigDecimal) = value.doubleValue(true)
}
