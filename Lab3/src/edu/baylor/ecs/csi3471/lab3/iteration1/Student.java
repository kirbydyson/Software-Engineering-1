package edu.baylor.ecs.csi3471.lab3.iteration1;

public class Student {
    private String name;
    private int id;
    private double gpa;

    public Student(){
        name = "";
        id = 0;
        gpa = 0.0;
    }
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getGpa() {
        return gpa;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
