package com.github.manosbatsis.kmm.converters.springboot.autoconfigure

import com.benasher44.uuid.Uuid
import com.github.manosbatsis.kmm.converters.jpa.com.benasher44.UuidAttributeConverter
import com.github.manosbatsis.kmm.converters.jpa.com.ionspin.BigDecimalAttributeConverter
import com.github.manosbatsis.kmm.converters.jpa.com.ionspin.BigIntegerAttributeConverter
import com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime.JpaConverter
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.datetime.*
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AutoConfiguration {

    @Bean
    @ConditionalOnClass(Uuid::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.benasher44.uuid.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun uuidAttributeConverter() = UuidAttributeConverter()

    @Bean
    @ConditionalOnClass(BigDecimal::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.ionspin.bigdecimal.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun bigDecimalAttributeConverter() = BigDecimalAttributeConverter()

    @Bean
    @ConditionalOnClass(BigInteger::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.ionspin.biginteger.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun bigIntegerAttributeConverter() = BigIntegerAttributeConverter()

    @Bean
    @ConditionalOnClass(LocalDate::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.datetime.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun localDateConverter() = JpaConverter.LocalDateConverter()

    @Bean
    @ConditionalOnClass(LocalTime::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.localtime.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun localTimeConverter() = JpaConverter.LocalTimeConverter()

    @Bean
    @ConditionalOnClass(Instant::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.instant.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun instantConverter() = JpaConverter.InstantConverter()

    @Bean
    @ConditionalOnClass(TimeZone::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.timezone.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun timeZoneConverter() = JpaConverter.TimeZoneConverter()

    @Bean
    @ConditionalOnClass(Month::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.month.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun monthConverter() = JpaConverter.MonthConverter()

    @Bean
    @ConditionalOnClass(DayOfWeek::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.dayofweek.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun dayOfWeekConverter() = JpaConverter.DayOfWeekConverter()

    @Bean
    @ConditionalOnClass(DateTimePeriod::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.datetimeperiod.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun dateTimePeriodConverter() = JpaConverter.DateTimePeriodConverter()

    @Bean
    @ConditionalOnClass(DatePeriod::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.dateperiod.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun datePeriodConverter() = JpaConverter.DatePeriodConverter()

    @Bean
    @ConditionalOnClass(UtcOffset::class)
    @ConditionalOnProperty(
        prefix = "manosbatsis",
        name = ["kmm.converters.kotlinx.utcoffset.disabled"],
        havingValue = "false",
        matchIfMissing = true
    )
    fun utcOffsetConverter() = JpaConverter.UtcOffsetConverter()
}
