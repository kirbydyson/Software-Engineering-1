package edu.baylor.ecs.csi3471.DysonKirby.module1;

public class StringExercise1{
    public String crazyCase(String s){
        if(s.toLowerCase().startsWith("i")){
            return s;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i % 2 == 0){
                result.append(Character.toUpperCase(c));
            } else{
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        StringExercise1 exercise1 = new StringExercise1();
        for(int i = 0; i < args.length; i++){
            System.out.println(exercise1.crazyCase(args[i]));
        }
    }
}