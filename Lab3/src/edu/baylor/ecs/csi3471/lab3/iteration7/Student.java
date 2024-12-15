package edu.baylor.ecs.csi3471.lab3.iteration7;

import java.util.Objects;

public class Student extends Person {
    private double gpa;
    private static int stuPopulation = 0;

    public Student(String name, int id, double gpa) {
        super(name, id);
        this.gpa = gpa;
        stuPopulation++;
    }
    public void accept(CitySimulation c){
        c.identify(this);
    }
    @Override
    public void printMe(){
        System.out.println("I am a student");
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
    @Override
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
