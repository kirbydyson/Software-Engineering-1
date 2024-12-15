package edu.baylor.ecs.csi3471.DysonKirby.module1;

public class StringExercise2 {
    public String[] splitter(String s){
        return s.split(",");
    }

    public static void main(String[] args) {
        StringExercise2 exercise = new StringExercise2();
        String[] result = new String[0];
        if(args.length > 0){
            result = exercise.splitter(args[0]);
        }
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i].trim());
        }
    }
}