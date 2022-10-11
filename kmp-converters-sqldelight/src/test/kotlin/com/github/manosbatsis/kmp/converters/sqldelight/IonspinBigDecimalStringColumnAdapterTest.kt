package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object IonspinBigDecimalStringColumnAdapterTest {

    val valueString = "179.99044"
    val value = BigDecimal.parseString(valueString)

    @Test
    fun decode() {
        assertEquals(value, IonspinBigDecimalStringColumnAdapter.decode(valueString))
    }

    @Test
    fun encode() {
        assertEquals(valueString, IonspinBigDecimalStringColumnAdapter.encode(value))
    }
}
