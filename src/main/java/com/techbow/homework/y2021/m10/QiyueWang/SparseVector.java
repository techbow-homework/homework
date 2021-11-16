package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.TreeMap;

public class SparseVector {
    private int size;
    private TreeMap<Integer, Double> map;

    public SparseVector(int size){
        this.size = size;
        this.map = new TreeMap<>();
    }

    public void set(int index, double val){
        if(index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + index + " out of bound of " + size
            );
        }
        map.put(index, val);
    }

    public double get(int index){
        if(index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + index + " out of bound of " + size
            );
        }
        return map.getOrDefault(index, 0.0);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append("["+ i + ", " + map.getOrDefault(i, 0.0) + "]");
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public SparseVector add(SparseVector v2){
        if(v2.size != size){
            throw new IllegalArgumentException("size not equal");
        }
        SparseVector res = new SparseVector(size);
        for(int i : this.map.keySet()){
            res.map.put(i, this.map.get(i));
        }
        for(int i : v2.map.keySet()){
            double temp = res.map.getOrDefault(i, 0.0);
            res.map.put(i, temp + v2.map.get(i));
        }
        return res;
    }

    public double dot(SparseVector v2){
        if(v2.size != size){
            throw new IllegalArgumentException("size not equal");
        }
        SparseVector v1 = this;
        double res = 0;
        for(int i : v2.map.keySet()){
            if(v1.map.containsKey(i)) {
                res += v1.map.get(i) * v2.map.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SparseVector v = new SparseVector(10);
        SparseVector v2 = new SparseVector(10);
        v.set(1, 2.5);
        v.set(0, 4.0);
        v2.set(1, 1.5);
        v2.set(3, 3.0);
        System.out.println(v.get(8));
        System.out.println(v.get(1));
        try {
            System.out.println(v.get(111));
            throw new IllegalStateException("We should not get here, an exception should have been thrown");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Please enter an index within range " + v.size);
        }
        System.out.println(v.add(v2));
        System.out.println(v.dot(v2));
        //System.out.println(v.toString());
    }
}

