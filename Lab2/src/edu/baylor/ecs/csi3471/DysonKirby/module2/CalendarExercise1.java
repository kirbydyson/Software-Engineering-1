package edu.baylor.ecs.csi3471.DysonKirby.module2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExercise1 {
    public void printDate(Calendar cal){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm::ss");
        sdf.setTimeZone(cal.getTimeZone());
        System.out.println(sdf.format(cal.getTime()));
    }
    public static void main(String[] args) {
        CalendarExercise1 exercise = new CalendarExercise1();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -2);
        exercise.printDate(cal);
        cal.add(Calendar.MONTH, 4);
        exercise.printDate(cal);
    }
}
