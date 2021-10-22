package com.techbow.homework.y2021.m10.yeboyr.Oct20;

class Person{
    private String firstName;
    private String lastName;
    private int id;
    private int salary;

    public void setInfo(String firstName,String lastName, int id,int salary){

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
    }

    public void setInfo(String FirstName,String LastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 0;
        this.salary = 1000;

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getId(){
        return id;
    }

    public int getSalary(){
        return salary;
    }

    public String toString(){
        return "Employee's name:" + this.firstName + " " + this.lastName + ".Id:" + this.id + " Salary:" + this.salary + ".";

    }

    public void raise(int amount){

        this.salary = salary + amount;

    }

}
