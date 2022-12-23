package bkap.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Validate {
    public static final String BIRTHDAY_PATTERN = "^[0-9]{1,2}[\\-\\/]{1}[0-9]{1,2}[\\-\\/]{1}[0-9]{1,4}$";

    public static boolean checkBirthDay(String birthday) throws ParseException {
        boolean check;
        if (birthday.matches(BIRTHDAY_PATTERN)) {
            String date = birthday.replaceAll("-", "/");
            String[] arr = date.split("/");
            int day = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int year = Integer.parseInt(arr[2]);
            boolean isLeapYear = checkLeapYear(year);
            boolean isCheck = checkDay(date);
            if (isCheck) {
                if (year > 0 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day > 0 && day <= 31) {
                            return true;
                        }
                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        if (day > 0 && day <= 30) {
                            return true;
                        }
                    } else if (month == 2) {
                        if (day > 0 && day <= (isLeapYear ? 29 : 28)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDay(String day) throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Date birth = s.parse(day);
        if (date.compareTo(birth) < 0) {
            return false;
        } else {
            return true;
        }
    }
}
