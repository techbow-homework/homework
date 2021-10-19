package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

public class Practice_20211007 {
    //把成员变量改为private,这样无法从外部更改该变量的值,保证了其安全性,只能用类里的方法更改数值
    //this关键字 是把当前Method的值传递到成员变量[当前Class里的变量],也可以调用当前Class的method


    public static void main(String[] args) {
        Phone p1 = new Phone();//initialize by default value
        System.out.println(p1.getBrand()+"-"+p1.getColor()+"-"+p1.getPrice());
        Phone p2 = new Phone("nokia",1000,"white");
        System.out.println(p2.getBrand()+"-"+p2.getColor()+"-"+p2.getPrice());
        Rectangle R1 = new Rectangle();
        System.out.println(R1.getArea());
        Rectangle R2 = new Rectangle(2);
        System.out.println(R2.getPerimeter());
        Rectangle R3 = new Rectangle(4,5);
        System.out.println(R3.getArea());

    }
}
class Phone{
    private String brand;

    private int price;
    private String color;

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void call(String name){
        System.out.println("Call "+name);
    }
    public Phone(){}
    public Phone(String brand,int price,String color){
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
}
class Rectangle {
    private float height;
    private float width;

    public float getLength() {
        return width;
    }

    public void setLength(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getArea() {
        return width * height;
    }

    public float getPerimeter() {
        ;
        return 2 * (width + height);
    }

    public Rectangle() {
        height = 1;
        width = 1;
    }

    public Rectangle(float length) {
        height = length;
        width = length;
    }

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }
}
