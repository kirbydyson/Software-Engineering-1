package edu.baylor.ecs.csi3471.DysonKirby.module2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class CalendarExercise2 {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String processDate(String s) throws ParseException{
        Date date = sdf.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 2);
        cal.add(Calendar.MINUTE, 2);
        return sdf.format(cal.getTime());
    }

    public void test(String s) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(s));
        cal.add(Calendar.HOUR, 2);
        cal.add(Calendar.MINUTE, 2);
        String expected = sdf.format(cal.getTime());
        String result = processDate(s);
        System.out.println("Expected: " + expected);
        System.out.println("Received: " + result);
    }

    public static void main(String[] args) throws ParseException{
        if(args.length > 0){
            CalendarExercise2 exercise = new CalendarExercise2();
            exercise.test(args[0]);
        }
    }
}