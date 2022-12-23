import bkap.validate.Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11-12-2023");
        list.add("11-12-2021");
        list.add("30-2-2021");
        list.add("29-2-2021");
        list.add("18-13-2020");
        list.add("1-2-1");
        list.add("24-12-2022");
        list.forEach(day->{
            boolean check = false;
            try {
                check = Validate.checkBirthDay(day);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.err.println(check);});

    }
}