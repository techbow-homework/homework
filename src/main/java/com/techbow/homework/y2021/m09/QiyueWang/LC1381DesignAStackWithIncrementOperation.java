package com.techbow.homework.y2021.m09.QiyueWang;

public class LC1381DesignAStackWithIncrementOperation {
    private int maxSize;
    private int[] stack;
    private int[] add;
    private int pointer; // point to the next pos, also as size

    public LC1381DesignAStackWithIncrementOperation(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.add = new int[maxSize];
        this.pointer = 0;
    }

    public void push(int x) {
        if(pointer >= maxSize) return;
        stack[pointer] = x;
        pointer++;
    }

    public int pop() {
        if(pointer < 1) return -1;
        pointer--;
        int res = stack[pointer] + add[pointer];
        if(pointer > 0){
            add[pointer - 1] += add[pointer]; // pass value to new top
        }
        add[pointer] = 0; // reset increment
        return res;
    }

    public int peek(){
        return stack[pointer - 1] + add[pointer - 1];
    }

    public void increment(int k, int val) {
        int num = 0;
        if(k >= pointer) num = pointer;
        else num = k;

        if(num > 0) add[num - 1] += val; // only increment top
    }

    public static void main(String[] args) {
        int mSize = 3;
        LC1381DesignAStackWithIncrementOperation obj = new LC1381DesignAStackWithIncrementOperation(mSize);
        obj.push(3);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.peek());
        obj.push(1);
        System.out.println(obj.peek());
        obj.increment(2,1);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
