package com.techbow.homework.y2021.m10.yuewen;

import java.util.Arrays;
public class minHeap {
    //class character
    private int curSzie;
    private int capacity;
    private int[] array; //heap is a array storage

    //constructor
    public minHeap() {
        //MODEL OF ANY HEAP
        this.curSzie=0;
        this.capacity=8;
        this.array=new int[this.capacity];
    }


    public minHeap(int [] input){
        if (input == null){
            throw new IllegalArgumentException();
        }
        this.curSzie=input.length;
        this.capacity=input.length *2 ;
        this.array=new int[this.capacity];
        for (int i=0; i<input.length; i++){
            this.array[i]=input[i];
        }
        buildHeap();
    }

    //build heap
    public void buildHeap(){
        for(int i=(this.curSzie)/2;i>=0;i--){
            heapify(i);
        }
    }

    public void heapify(int index){
        int p = index;
        while (p<this.curSzie){
            int l=p*2+1;
            int r=p*2+2;
            int min=p;
            //left child compare
            if (l<this.curSzie && array[l]<array[p]){
                min=l;
            }
            //right child compare
            if (r < this.curSzie && array[r] < array[min]) {
                min = r;
            }
            //swap
            if(min != p){
                swap(p, min);
                p=min;
            } else{
                break;
            }

        }
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    //size
    public int size(){
        return this.curSzie;
    }
    //getmin
    public int getMin(){
        if(this.curSzie<1){
            throw new IllegalArgumentException("OFB");
        }
        return this.array[0];
    }
    //extract min
    public int extractMin(){
        if(this.curSzie<1){
            throw new IllegalArgumentException("OFB");
        }
        int min=array[0];
        swap(0, this.curSzie-1);
        this.curSzie=this.curSzie-1;
        heapify(0);

        return min;
    }
    //add ----bottom to up why bottom to up cannot direct use heapify
    public void add(int val){
        if (this.curSzie==this.capacity){
            giveBigRoom();
        }
        //append to array edn
        array[this.curSzie]=val;
        //bottom to up heapfiy
        int cur = this.curSzie++;
        while(cur>0){
            int p = (cur-1)/2;
            if(p>=0 && array[cur]<array[p]){
                swap(cur, p);
                cur=p;
            }else{
                break;
            }
        }
    }
    public void giveBigRoom(){
        this.capacity=this.capacity*2;
        int [] newarray = new int[this.capacity];
        for(int i=0;i<this.curSzie;i++){
            newarray[i]=this.array[i];
        }
        this.array=newarray;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.array, this.curSzie));
    }
    public static void main(String[] args) {
        int[] input = {9, 10, 9, 2, 3, 4, 5, 8, 1, 2};
        minHeap MH = new minHeap(input);

        System.out.print(MH);
        MH.extractMin();
        System.out.println(MH);

        //int i =10;
        //--i;
        //System.out.println(i);





    }

}