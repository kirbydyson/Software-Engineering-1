package edu.baylor.ecs.csi3471.lab3.iteration6;

import java.util.Random;
import java.util.Vector;

public class CitySimulation {
    public void dispatch(Person p){
        identify(p);
    }
    /* No, it does not print "I am a student" because the identify function
    is not a method of the parent class, so it does not have any elements
    of polymorphism or inheritance. As p is passed as a person object,
    it is identified as so.
    */
    public void identify(Person p){
        System.out.println("This is a person");
    }
    public void identify(Student s){
        System.out.println("This is a student");
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

