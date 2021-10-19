package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

public class Practice_20211013 {
    public static void main(String[] args) {
        Employee em1 = new Programmer("123","peter",100);
        em1.signIn();
        em1.work();
        Employee em2 = new Manager("124","mary",100,100);
        em2.signIn();
        em2.work();

    }
}

abstract class Employee{
    private  String id;
    private  String name;
    private  float pay;

    public Employee(String id, String name, float pay){
        this.id = id;
        this.name = name;
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPay() {
        return pay;
    }

    public abstract void work();
    public void signIn(){
        System.out.println(name+" is signing in");
    }
}

class Programmer extends Employee{
    public Programmer(String id, String name,float pay){
        super(id, name, pay);
    }

    @Override
    public void work() {
        System.out.println(getName()+" is Coding");
    }
}

class Manager extends Employee{
    private float bouns;

    public Manager(String id, String name,float pay,float bouns){
        super(id, name, pay);
        this.bouns = bouns;
    }

    @Override
    public void work(){
        System.out.println(getName()+" is Managing teams");
    }
}

