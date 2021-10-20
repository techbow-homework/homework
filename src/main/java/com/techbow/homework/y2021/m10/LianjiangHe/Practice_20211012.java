package com.techbow.homework.y2021.m10.LianjiangHe;

public class Practice_20211012 {
    public static void main(String[] args) {
        class Person{
            private  int age;
            private String name;
            public Person(int age,String name){
                this.age = age;
                this.name = name;
            }
            public void show(){
                System.out.println(name+'-'+age);
            }
        }

        Person p = new Person(50,"peter");
        p.show();
    }
}