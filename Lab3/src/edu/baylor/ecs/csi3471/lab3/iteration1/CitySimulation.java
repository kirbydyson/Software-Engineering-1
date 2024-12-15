package edu.baylor.ecs.csi3471.lab3.iteration1;

import java.util.Vector;
import java.util.Random;

public class CitySimulation {
    public static void main(String[] args) {
        Vector<Person> person = new Vector<>();
        Vector<Student> student = new Vector<>();
        Random rand = new Random();
        int students = 0;
        int people = 0;

        for(int i = 0; i < 100; i++){
            if (rand.nextBoolean()) {
                student.add(new Student("Student" + i, i, rand.nextDouble() * 4.0));
                students++;
            }
            else{
                person.add(new Person("Person" + i, i));
                people++;
            }
        }

        System.out.println("Total People: " + people);
        System.out.println("Total Students: " + students);
    }
}
