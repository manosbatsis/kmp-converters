package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object IonspinBigDecimalColumnAdapterTest {
    private val doubleExpectedByBigDecimal: List<Pair<BigDecimal, Number>> = listOf(
        Pair(BigDecimal.parseString("12.375"), 12.375),
        Pair(BigDecimal.parseString("375E305"), 375E305),
        // Pair(BigDecimal.parseString("375E-326"), 4.9E-324),
        Pair(BigDecimal.parseString("72057594037927928"), 72057594037927928.0),
    )

    @Test
    fun decode() {
        doubleExpectedByBigDecimal.forEach {
            assertEquals(
                it.first.toPlainString(),
                IonspinBigDecimalColumnAdapter.decode(it.second.toDouble()).toPlainString()
            )
        }
    }

    @Test
    fun encode() {
        doubleExpectedByBigDecimal.forEach {
            assertEquals(0, it.second.toDouble().compareTo(IonspinBigDecimalColumnAdapter.encode(it.first)))
        }
    }
}
