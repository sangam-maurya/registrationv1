package com.example.demo;

public class Employee {

     private String name;
     private int age ;
    private  double sallery;

    public Employee(String name , int age , double sallery ) {
        this.name = name;
        this.age = age;
        this.sallery=sallery;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + "sangam" + '\'' +
                ", age=" + age +
                ", sallery=" + sallery +
                '}';
    }
    public String getName() {
        return name;
    }

    public double getSallery() {
        return sallery;
    }

    public int getAge() {
        return age;
    }
}
