package edu.baylor.ecs.csi3471.lab3.iteration5;

import java.util.Random;
import java.util.Vector;

public class CitySimulation {
    /* Yes, it prints out "I am a student" because the printMe() method
     is implemented in both classes and the Student class overrides the
     parent class due to the nature of inheritance and polymorphism.
    */
    public void dispatch(Person p){
        p.printMe();
    }

    public static void main(String[] args) {
        Vector<Person> citizens = new Vector<>();
        Random rand = new Random();

        for(int i = 0; i < 100; i++){
            if(rand.nextBoolean()){
                citizens.add(new Student("Student" + i, i, rand.nextDouble() * 4.0));
            }
            else{
                citizens.add(new Person("Person" + i, i));
            }
            CitySimulation p = new CitySimulation();
            p.dispatch(citizens.get(i));
        }
        int totalPeople = Person.getPopulation() - Student.getPopulation();

        System.out.println("Total People: " + totalPeople);
        System.out.println("Total Students: " + Student.getPopulation());
    }
}

