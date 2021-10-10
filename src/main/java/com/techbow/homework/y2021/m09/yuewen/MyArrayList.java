package com.techbow.homework.y2021.m09.yuewen;

//https://segmentfault.com/a/1190000022903827
//i++：先进栈储存，返回栈的数值，再加一 ->i=1, i=i++, print(i)=1
//++i: i 变量先在局部变量表中进行自增，然后再将 i 进栈，然后再把栈中的数据返回给我们的变量 i
public class MyArrayList {
    //arraylist
    private int[] vals;
    //length
    private int capacity=4;
    //constructor a array
    //elementype [] array_name=new elementtype[length]
    private int idx=0;
    public MyArrayList(){
        this.vals=new int[this.capacity];
    }
    //method they need to get all field from the setting
    //add
    public int get (int index) {
        this.validateIndex(index);
        return this.vals[index];
    }
    //set
    public void set(int index, int val){
        this.validateIndex(index);
        this.vals[index]=val;

    }
    //size：if we need this size means the idx not the length(some empty)
    public int size(){
        //return idx;
        return this.vals.length;
    }
    //add=append
    //array[++index] - which means increment to variable index in current statement itself. array[index++] - which means increment to variable index after executing current
    public void add(int val){
        //add to the end need double sie of array and move
        if(this.idx==this.capacity){
            this.doublesize();
        }
        //int a = this.idx++;

        this.vals[idx++]=val;
        //System.out.println(idx++);
    }
    //insert ****
    public void insert(int index, int val){
        this.validateIndex(index);
        if(this.idx==this.capacity){
            this.doublesize();
        }
        //System.out.println(idx);
        //this one idx is 1 but after the following executing will make idx into 2
        this.idx++;

        int temp=val;
        for(int i=index;i<this.idx;i++){
            System.out.println("Imast"+i);
            System.out.println(this.idx);
            int tem_val=this.vals[i];
            this.vals[i]=temp;
            temp=tem_val;
            System.out.println("Ihave"+i);
        }

    }
    //remove ***
    public void remove(int index){
        this.validateIndex(index);
        for(int i=index;i<this.idx;i++){
            this.vals[i]=this.vals[i+1];

        }
        this.idx--;
    }
    //valid index
    private void validateIndex(int index) {
        //this.idx=index;
        if (index<0 || index>this.idx){
            throw new RuntimeException("Out of Boundary");
        }
    }
    //double size
    private void doublesize(){
        //create new array
        int [] newVals=new int[this.capacity*2];
        //move
        for(int i=0;i<this.idx;i++){
            newVals[i]=this.vals[i];
        }
        //update setting
        this.vals=newVals;
        this.capacity=this.capacity*2;
    }

    //toString ***
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < this.idx; i++) {
            sb.append(this.vals[i] + ", ");
        }
        sb.append("/");
        return sb.toString();
    }


    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        //System.out.print(list.idx);
        list.insert(1,14);
        //System.out.print(list.idx);

        //list.add(2);
        //list.add(3);
        //list.add(4);
        //System.out.println(list);
        //System.out.print(list.size());
        //list.insert(0,14);
        //System.out.println(list);
        //System.out.print(list.idx);
        //System.out.println(list);

        //  System.out.println(list);
        //  int get=list.get(1);
        //  System.out.println(get);
        // list.add(5);
        //  System.out.println(list);
        //  list.set(5,20);
        //  System.out.println(list);
        //  System.out.println(list.size());
    }
}
