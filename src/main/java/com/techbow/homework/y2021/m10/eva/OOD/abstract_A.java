package com.techbow.homework.y2021.m10.eva.OOD;

public class abstract_A {
    private int a;
    public A (int a){
        this.a = a;
    }
    public int cal(int x){return this.a + x}
}
public class B extends A{
    private int b;
    public B(int b, int a){
        super(a);
        this.b = b;
    }
}

