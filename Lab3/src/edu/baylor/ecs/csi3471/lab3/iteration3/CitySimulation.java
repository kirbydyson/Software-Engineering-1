package edu.baylor.ecs.csi3471.lab3.iteration3;

public class CitySimulation {
    public static void main(String[] args) {
        Student stu1 = new Student("Kirby Dyson", 12345, 4.0);
        Student stu2 = new Student("Kirby Dyson", 12345, 4.0);

        if(stu1.equals(stu2)){
            System.out.println("Student 1 and 2 are the same");
        }
        else{
            System.out.println("ERROR: Student 1 and 2 are not the same");
        }
        System.out.println("Student 1 hashcode: " + stu1.hashCode());
        System.out.println("Student 2 hashcode: " + stu2.hashCode());
    }
}
