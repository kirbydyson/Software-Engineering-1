package edu.baylor.ecs.csi3471.lab3.iteration1;

public class Person{
    private String name;
    private int id;

    public Person(){
        name = "";
        id = 0;
    }
    public Person(String name, int id){
        this.name = name;
        this.id = id;
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