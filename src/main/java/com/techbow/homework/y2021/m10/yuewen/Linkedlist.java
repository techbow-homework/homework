package com.techbow.homework.y2021.m09.yuewen;

public class Linkedlist {
    //?????
    private class ListNode{
        int item;
        ListNode next;
        ListNode prev;
        //constructor
        public ListNode(int item) {
            this.item=item;
        }
    }
    //define a listnode class
    int cursize=0;
    private ListNode head;
    private ListNode tail;
    //constuctor
    public Linkedlist(){
        this.cursize=cursize;
        this.head=new ListNode(-1);
        this.tail=new ListNode(-1);
        //construct double lise
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    public int size(){
        return this.cursize; //??why this
    }

    public int get(int index){
        this.valideindex(index);
        return this.getnode(index).item;
    }

    public void add(int val){
        ListNode addme=new ListNode(val);
        ListNode preve=this.tail.prev;
        //addmeBehide
        this.addmeBehind(preve, addme);
        this.cursize++;

    }

    public void addtolist(int val, int index){
        this.valideindex(index);
        //node(index)->addme(value)->node.next
        ListNode addme=new ListNode(val);
        ListNode node = this.getnode(index);
        this.addmeBehind(node, addme);
        this.cursize++;


    }

    public void remove(int index){
        //a1->removeme(index)->a2
        //a1->a2
        this.valideindex(index);
        ListNode removeme=this.getnode(index);
        ListNode a1=removeme.prev;
        ListNode a2=removeme.next;
        a1.next=a2;
        a2.prev=a1;
        this.cursize--;

    }

    public void valideindex(int index){
        if(index<0 || index>=this.cursize){
            throw new ArrayIndexOutOfBoundsException("OFB");
        }
    }

    public ListNode getnode(int i){
        ListNode curr=this.head.next;
        while(i-->0){
            curr=curr.next;
        }
        return curr;//if 0 will be -- if length of linkedlist will be ++????
    }

    public void addmeBehind(ListNode node, ListNode addMe){
        if (node==null){
            throw new IllegalArgumentException("NULL");
        }
        ListNode next=node.next;
        //addMe<->Node.next
        addMe.next=next;
        next.prev=addMe;

        //node<->addMe
        node.next=addMe;
        addMe.prev=node;



    }
    //main function
    public static void main(String[] args) {
        //????
        Linkedlist list = new Linkedlist();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();

        list.addtolist(90, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();


        list.addtolist(55, 55);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();

        list.remove(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }

}
