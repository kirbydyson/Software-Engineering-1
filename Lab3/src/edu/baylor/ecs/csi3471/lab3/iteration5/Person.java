package edu.baylor.ecs.csi3471.lab3.iteration5;

import java.util.Objects;

public class Person{
    private String name;
    private int id;
    private static int population = 0;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
        population++;
    }
    public void printMe(){
        System.out.println("I am a person");
    }
    public static int getPopulation(){
        return population;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person)obj;
        return id == person.id && Objects.equals(name, person.name);
    }
    public int hashCode(){
        return Objects.hash(id, name);
    }
}