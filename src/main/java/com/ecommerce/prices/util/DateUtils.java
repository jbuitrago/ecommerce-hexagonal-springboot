package com.ecommerce.prices.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String dateStr) throws ParseException {
        return DATE_FORMAT.parse(dateStr);
    }

    public static boolean isValidDateRange(Date startDate, Date endDate) {
        return startDate != null && endDate != null && !startDate.after(endDate);
    }

    public static boolean isValidDateFormat(String dateStr) {
        DATE_FORMAT.setLenient(false); // No permitir fechas inválidas
        try {
            DATE_FORMAT.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
