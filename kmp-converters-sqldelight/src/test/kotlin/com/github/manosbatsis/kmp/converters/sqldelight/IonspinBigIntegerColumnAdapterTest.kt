package com.github.manosbatsis.kmp.converters.sqldelight

import com.ionspin.kotlin.bignum.integer.BigInteger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object IonspinBigIntegerColumnAdapterTest {

    val bigIntegerString = "17999044"
    val valueLong = bigIntegerString.toLong()
    val value = BigInteger.parseString(bigIntegerString)

    @Test
    fun decode() {
        assertEquals(value, IonspinBigIntegerColumnAdapter.decode(valueLong))
    }

    @Test
    fun encode() {
        assertEquals(valueLong, IonspinBigIntegerColumnAdapter.encode(value))
    }
}
