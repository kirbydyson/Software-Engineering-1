package edu.baylor.ecs.csi3471.lab3.iteration2;

public class Person{
    private String name;
    private int id;
    private static int population = 0;

    public Person(){
        name = "";
        id = 0;
    }
    public Person(String name, int id){
        this.name = name;
        this.id = id;
        population++;
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
}