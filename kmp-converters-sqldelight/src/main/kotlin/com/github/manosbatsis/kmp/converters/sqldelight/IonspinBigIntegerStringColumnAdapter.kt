package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.squareup.sqldelight.ColumnAdapter

object IonspinBigIntegerStringColumnAdapter : ColumnAdapter<BigInteger, String> {
    override fun decode(databaseValue: String) = BigInteger.parseString(databaseValue)

    override fun encode(value: BigInteger) = value.toString()
}
