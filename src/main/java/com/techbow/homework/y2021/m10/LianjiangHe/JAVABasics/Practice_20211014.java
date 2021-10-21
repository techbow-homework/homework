package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

public class Practice_20211014 {
    public static void main(String[] args) {
       /* B b = new B();
        b.method1();
        b.method3();*/
        A2 c = new C();
        c.method3();
        c.method4();
        ((C)c).method1();
        ((A1)c).method1();
    }
}
interface A1{
    void method1();
    void method2();
}
interface A2{
    void method3();
    void method4();
}
class C implements A1,A2{
    @Override
    public void method1() {
        System.out.println("this is method 1");
    }

    @Override
    public void method2() {
        System.out.println("this is method 2");
    }

    @Override
    public void method3() {
        System.out.println("this is method 3");
    }

    @Override
    public void method4() {
        System.out.println("this is method 4");
    }
}

