package pocGraphql.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    // Pattern for Date and LocalDateTime
    private static final String PATTERN = "dd/MM/yyyy HH:mm";

    /**
     * Used in Date types
     */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);

    /**
     * Used in LocalDateTimes types
     */
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);

    // Setting TimeZone for -3
    static {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }

    // Date type

    /**
     * Convert Date for String
     * */
    public static String toString(Date date) {
        return simpleDateFormat.format(date);
    }

    /**
     * Convert String for Date
     * */
    public static Date toDate(String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    // LocalDateTime

    /**
     * Convert LocalDateTime for String
     * */
    public static String toString(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * Convert String for LocalDateTime
     * */
    public static LocalDateTime toLocalDateTime(String localDateTimeString) {
        try {
            return LocalDateTime.parse(localDateTimeString);
        } catch (DateTimeParseException e) {
            return null;
        }
    }


}
