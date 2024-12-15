package edu.baylor.ecs.csi3471.lab3.iteration2;

import java.util.Random;
import java.util.Vector;

public class CitySimulation {
    public static void main(String[] args) {
        Vector<Person> person = new Vector<>();
        Vector<Student> student = new Vector<>();
        Random rand = new Random();

        for(int i = 0; i < 100; i++){
            if(rand.nextBoolean()){
                student.add(new Student("Student" + i, i, rand.nextDouble() * 4.0));
            }
            else{
                person.add(new Person("Person" + i, i));
            }
        }

        System.out.println("Total People: " + Person.getPopulation());
        System.out.println("Total Students: " + Student.getPopulation());
    }
}
