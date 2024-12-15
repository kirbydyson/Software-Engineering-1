package edu.baylor.ecs.csi3471.DysonKirby.module1;

public class StringExercise3 {
    public String httpRemover(String s){
        return s.replaceAll("(?i)https?://", "");
    }

    public static void main(String[] args) {
        StringExercise3 exercise = new StringExercise3();
        for(int i = 0; i < args.length; i++) {
            System.out.println(exercise.httpRemover(args[i]));
        }
    }
}

