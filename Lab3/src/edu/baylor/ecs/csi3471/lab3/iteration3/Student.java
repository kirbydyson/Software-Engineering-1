package edu.baylor.ecs.csi3471.lab3.iteration3;

import java.util.Objects;

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
        super(name, id);
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
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!super.equals(obj)){
            return false;
        }
        Student stu = (Student) obj;
        return Double.compare(stu.gpa, this.gpa) == 0;
    }
    public int hashCode(){
        return Objects.hash(super.hashCode(), gpa);
    }
}
