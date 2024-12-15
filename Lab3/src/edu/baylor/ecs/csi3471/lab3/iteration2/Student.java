package edu.baylor.ecs.csi3471.lab3.iteration2;

public class Student extends Person {
    private String name;
    private int id;
    private double gpa;
    private static int stuPopulation = 0;

    public Student() {
        name = "";
        id = 0;
        gpa = 0.0;
    }
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        stuPopulation++;
    }
    public static int getPopulation(){
        return stuPopulation;
    }
    public double getGpa(){
        return gpa;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
}
