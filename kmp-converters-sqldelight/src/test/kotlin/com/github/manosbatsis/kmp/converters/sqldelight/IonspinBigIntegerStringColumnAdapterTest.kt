package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.integer.BigInteger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object IonspinBigIntegerStringColumnAdapterTest {

    val valueString = "17999044"
    val value = BigInteger.parseString(valueString)

    @Test
    fun decode() {
        assertEquals(value, IonspinBigIntegerStringColumnAdapter.decode(valueString))
    }

    @Test
    fun encode() {
        assertEquals(valueString, IonspinBigIntegerStringColumnAdapter.encode(value))
    }
}
