package com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime

import com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime.OneWayConverter.*
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.sql.Timestamp
import java.time.ZoneOffset
import java.util.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

class JpaConverter {
    @Converter(autoApply = true)
    class LocalDateConverter : AttributeConverter<LocalDate?, Date?> {
        override fun convertToDatabaseColumn(attribute: LocalDate?): Date? {
            return if (attribute == null) null else LocalDateToDateConverter.convert(attribute)
        }

        override fun convertToEntityAttribute(dbData: Date?): LocalDate? {
            return if (dbData == null) null else DateToLocalDateConverter.convert(dbData)
        }
    }

    @Converter(autoApply = true)
    class LocalTimeConverter : AttributeConverter<LocalTime?, Date?> {
        override fun convertToDatabaseColumn(attribute: LocalTime?): Date? {
            return if (attribute == null) null else LocalTimeToDateConverter.convert(attribute)
        }

        override fun convertToEntityAttribute(dbData: Date?): LocalTime? {
            return if (dbData == null) null else DateToLocalTimeConverter.convert(dbData)
        }
    }

    @Converter(autoApply = true)
    class LocalDateTimeConverter : AttributeConverter<LocalDateTime?, Date?> {
        override fun convertToDatabaseColumn(attribute: LocalDateTime?): Date? {
            return if (attribute == null) null else LocalDateTimeToDateConverter.convert(attribute)
        }

        override fun convertToEntityAttribute(dbData: Date?): LocalDateTime? {
            return if (dbData == null) null else DateToLocalDateTimeConverter.convert(dbData)
        }
    }

    @Converter(autoApply = true)
    class InstantConverter : AttributeConverter<Instant?, Timestamp?> {
        override fun convertToDatabaseColumn(attribute: Instant?): Timestamp? {
            return if (attribute == null) null else InstantToTimestampConverter.convert(attribute)
        }

        override fun convertToEntityAttribute(dbData: Timestamp?): Instant? {
            return if (dbData == null) null else TimestampToInstantConverter.convert(dbData)
        }
    }

    @Converter(autoApply = true)
    class TimeZoneConverter : AttributeConverter<TimeZone?, String?> {
        override fun convertToDatabaseColumn(attribute: TimeZone?): String? {
            return if (attribute == null) null else TimeZoneToStringConverter.convert(attribute)
        }

        override fun convertToEntityAttribute(dbData: String?): TimeZone? {
            return if (dbData == null) null else StringToTimeZoneConverter.convert(dbData)
        }
    }

    @Converter(autoApply = true)
    class MonthConverter : AttributeConverter<Month?, Short?> {
        override fun convertToDatabaseColumn(attribute: Month?): Short? {
            return attribute?.value?.toShort()
        }

        override fun convertToEntityAttribute(dbData: Short?): Month? {
            return if (dbData == null) null else Month.of(dbData.toInt())
        }
    }

    @Converter(autoApply = true)
    class DayOfWeekConverter : AttributeConverter<DayOfWeek?, Short?> {
        override fun convertToDatabaseColumn(attribute: DayOfWeek?): Short? {
            return attribute?.value?.toShort()
        }

        override fun convertToEntityAttribute(dbData: Short?): DayOfWeek? {
            return if (dbData == null) null else DayOfWeek.of(dbData.toInt())
        }
    }

    @Converter(autoApply = true)
    class DateTimePeriodConverter : AttributeConverter<DateTimePeriod?, String?> {
        override fun convertToDatabaseColumn(attribute: DateTimePeriod?): String? {
            return attribute?.toString()
        }

        override fun convertToEntityAttribute(dbData: String?): DateTimePeriod? {
            return if (dbData == null) null else DateTimePeriod.parse(dbData)
        }
    }

    @Converter(autoApply = true)
    class DatePeriodConverter : AttributeConverter<DatePeriod?, String?> {
        override fun convertToDatabaseColumn(attribute: DatePeriod?): String? {
            return attribute?.toString()
        }

        override fun convertToEntityAttribute(dbData: String?): DatePeriod? {
            return if (dbData == null) null else DatePeriod.parse(dbData)
        }
    }

    @Converter(autoApply = true)
    class UtcOffsetConverter : AttributeConverter<UtcOffset?, Int?> {
        override fun convertToDatabaseColumn(attribute: UtcOffset?): Int? {
            return attribute?.totalSeconds
        }

        override fun convertToEntityAttribute(dbData: Int?): UtcOffset? {
            return if (dbData == null) null else UtcOffset(ZoneOffset.ofTotalSeconds(dbData))
        }
    }
}
