package com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime

import com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime.OneWayConverter.*
import kotlinx.datetime.*
import javax.persistence.AttributeConverter
import java.util.Date
import java.sql.Timestamp
import javax.persistence.Converter

class JpaConverter {
    @Converter(autoApply = false)
    class LocalDateConverter : AttributeConverter<LocalDate?, Date?> {
        override fun convertToDatabaseColumn(date: LocalDate?): Date? {
            return if (date == null) null else LocalDateToDateConverter.convert(date)
        }

        override fun convertToEntityAttribute(date: Date?): LocalDate? {
            return if (date == null) null else DateToLocalDateConverter.convert(date)
        }
    }

    @Converter(autoApply = false)
    class LocalTimeConverter : AttributeConverter<LocalTime?, Date?> {
        override fun convertToDatabaseColumn(time: LocalTime?): Date? {
            return if (time == null) null else LocalTimeToDateConverter.convert(time)
        }

        override fun convertToEntityAttribute(date: Date?): LocalTime? {
            return if (date == null) null else DateToLocalTimeConverter.convert(date)
        }
    }

    @Converter(autoApply = false)
    class LocalDateTimeConverter : AttributeConverter<LocalDateTime?, Date?> {
        override fun convertToDatabaseColumn(date: LocalDateTime?): Date? {
            return if (date == null) null else LocalDateTimeToDateConverter.convert(date)
        }

        override fun convertToEntityAttribute(date: Date?): LocalDateTime? {
            return if (date == null) null else DateToLocalDateTimeConverter.convert(date)
        }
    }

    @Converter(autoApply = false)
    class InstantConverter : AttributeConverter<Instant?, Timestamp?> {
        override fun convertToDatabaseColumn(instant: Instant?): Timestamp? {
            return if (instant == null) null else InstantToTimestampConverter.convert(instant)
        }

        override fun convertToEntityAttribute(timestamp: Timestamp?): Instant? {
            return if (timestamp == null) null else TimestampToInstantConverter.convert(timestamp)
        }
    }

    @Converter(autoApply = false)
    class ZoneIdConverter : AttributeConverter<TimeZone?, String?> {
        override fun convertToDatabaseColumn(zoneId: TimeZone?): String? {
            return if (zoneId == null) null else TimeZoneToStringConverter.convert(zoneId)
        }

        override fun convertToEntityAttribute(zoneId: String?): TimeZone? {
            return if (zoneId == null) null else StringToTimeZoneConverter.convert(zoneId)
        }
    }
}
