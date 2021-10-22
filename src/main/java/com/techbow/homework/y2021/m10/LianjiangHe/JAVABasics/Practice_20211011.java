package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

public class Practice_20211011 {
    public static void main(String[] args) {
        B b = new B();
        b.method1();
        A a = new B();//A范围大B小,A参数少,B参数多.所以A可以通过B方法新建对象,而B不能通过A新建对象,无法从A中找到必要的
        a.method1();
        // B b2 = new A();
    }
}

abstract class A {
    private int a;
    public String b;

    abstract void method1();//抽象方法只能在抽象类里
}

class B extends A {
    //如果抽象类的子类是完整的类,则它必须重写所有的 抽象方法
    public void method1() {
        System.out.println("hello");
    }
}

