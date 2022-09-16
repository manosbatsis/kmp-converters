package com.github.manosbatsis.kmm.converters.jpa.kotlinx.datetime

import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.TimeZone.Companion.currentSystemDefault
import java.sql.Timestamp
import java.util.*
import kotlin.time.Duration

interface OneWayConverter<X, Y> {

    fun convert(source: X): Y

    object DateToLocalDateTimeConverter : OneWayConverter<Date, LocalDateTime> {
        override fun convert(source: Date): LocalDateTime {
            return source.toInstant()
                .toKotlinInstant()
                .toLocalDateTime(currentSystemDefault())
        }
    }

    object LocalDateTimeToDateConverter : OneWayConverter<LocalDateTime, Date> {
        override fun convert(source: LocalDateTime): Date {
            return Date.from(source.toInstant(currentSystemDefault()).toJavaInstant())
        }
    }
    object DateToLocalDateConverter : OneWayConverter<Date, LocalDate> {
        override fun convert(source: Date): LocalDate {
            return source.toInstant().toKotlinInstant().toLocalDateTime(currentSystemDefault()).date
        }
    }

    object LocalDateToDateConverter : OneWayConverter<LocalDate, Date> {
        override fun convert(source: LocalDate): Date {
            return Date.from(source.atStartOfDayIn(currentSystemDefault()).toJavaInstant())
        }
    }

    object DateToLocalTimeConverter : OneWayConverter<Date, LocalTime> {
        override fun convert(source: Date): LocalTime {
            return Instant.fromEpochMilliseconds(source.time).toLocalDateTime(currentSystemDefault()).time
        }
    }

    object LocalTimeToDateConverter : OneWayConverter<LocalTime, Date> {

        override fun convert(source: LocalTime): Date {
            val sourceToday = Clock.System.now().toLocalDateTime(currentSystemDefault()).date.atTime(source)
            return Date.from(sourceToday.toInstant(currentSystemDefault()).toJavaInstant())
        }
    }

    object DateToInstantConverter : OneWayConverter<Date, Instant> {
        override fun convert(source: Date): Instant {
            return source.toInstant().toKotlinInstant()
        }
    }

    object InstantToDateConverter : OneWayConverter<Instant, Date> {
        override fun convert(source: Instant): Date {
            return Date.from(source.toJavaInstant()) as Date
        }
    }

    object LocalDateTimeToInstantConverter : OneWayConverter<LocalDateTime, Instant> {
        override fun convert(source: LocalDateTime): Instant {
            return source.toInstant(currentSystemDefault())
        }
    }

    object InstantToLocalDateTimeConverter : OneWayConverter<Instant, LocalDateTime> {
        override fun convert(source: Instant): LocalDateTime {
            return source.toLocalDateTime(currentSystemDefault())
        }
    }

    object TimeZoneToStringConverter : OneWayConverter<TimeZone, String> {
        override fun convert(source: TimeZone): String {
            return source.toString()
        }
    }

    object StringToTimeZoneConverter : OneWayConverter<String, TimeZone> {
        override fun convert(source: String): TimeZone {
            return TimeZone.of(source)
        }
    }

    object DurationToStringConverter : OneWayConverter<Duration, String> {
        override fun convert(source: Duration): String {
            return source.toString()
        }
    }

    object StringToDurationConverter : OneWayConverter<String, Duration> {
        override fun convert(source: String): Duration {
            return Duration.parse(source)
        }
    }

    object DateTimePeriodToStringConverter : OneWayConverter<DateTimePeriod, String> {
        override fun convert(source: DateTimePeriod): String {
            return source.toString()
        }
    }

    object StringToDateTimePeriodConverter : OneWayConverter<String, DateTimePeriod> {
        override fun convert(source: String): DateTimePeriod {
            return DateTimePeriod.parse(source)
        }
    }

    object StringToLocalDateConverter : OneWayConverter<String, LocalDate> {
        override fun convert(source: String): LocalDate {
            return LocalDate.parse(source)
        }
    }

    object StringToLocalDateTimeConverter : OneWayConverter<String, LocalDateTime> {
        override fun convert(source: String): LocalDateTime {
            return LocalDateTime.parse(source)
        }
    }

    object StringToInstantConverter : OneWayConverter<String, Instant> {
        override fun convert(source: String): Instant {
            return Instant.parse(source)
        }
    }

    object TimestampToInstantConverter : OneWayConverter<Timestamp, Instant> {

        override fun convert(source: Timestamp): Instant {
            return source.toInstant().toKotlinInstant()
        }
    }

    object InstantToTimestampConverter : OneWayConverter<Instant, Timestamp> {
        override fun convert(source: Instant): Timestamp {
            return Timestamp.from(source.toJavaInstant())
        }
    }
}
