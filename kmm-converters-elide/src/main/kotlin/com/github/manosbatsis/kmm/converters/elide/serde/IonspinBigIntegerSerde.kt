package com.github.manosbatsis.kmm.converters.elide.serde

import com.yahoo.elide.core.utils.coerce.converters.ElideTypeConverter
import com.yahoo.elide.core.utils.coerce.converters.Serde
import java.math.BigInteger
import com.ionspin.kotlin.bignum.integer.BigInteger as KBigInteger

@ElideTypeConverter(type = KBigInteger::class, name = "IonspinBigInteger")
class IonspinBigIntegerSerde : Serde<BigInteger?, KBigInteger?> {
  override fun deserialize(value: BigInteger?): KBigInteger? {
    return if (value == null) null else KBigInteger.parseString(value.toString())
  }

  override fun serialize(value: KBigInteger?): BigInteger? {
    return BigInteger(value.toString())
  }
}
