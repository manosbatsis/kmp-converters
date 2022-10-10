package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.squareup.sqldelight.ColumnAdapter

object IonspinBigIntegerColumnAdapter : ColumnAdapter<BigInteger, Long> {
    override fun decode(databaseValue: Long) = BigInteger.fromLong(databaseValue)

    override fun encode(value: BigInteger) = value.longValue(true)
}
