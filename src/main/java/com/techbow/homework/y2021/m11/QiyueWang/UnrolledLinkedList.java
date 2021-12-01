package com.techbow.homework.y2021.m11.QiyueWang;
class Node{
    char[] chars;
    int len;//how many chars in the arr
    Node next;
    public Node(){
        chars = new char[5];
        len = 0;
        next = null;
    }
}

public class UnrolledLinkedList {
    Node head;
    int totalLen;
    public  UnrolledLinkedList(Node head){
        this.head = head;
//  get total len
        int count = 0;
        Node cur = head;
        while(cur != null){
            count += cur.len;
            cur = cur.next;
        }
        this.totalLen = count;
        System.out.println("Total length is : "+ totalLen );
    }

    public char get(int index){
        if(index >= totalLen || index < 0) return ' ';
        Node cur = head;
        while (cur != null && index >= 0 ){
            if(cur.len <= index) {
                index -= cur.len;
            }else{
                break;
            }
            cur = cur.next;
        }
        return cur.chars[index];
    }

    public void insert(char ch, int index){
        if(index < 0 || index > totalLen) return;
        Node cur = head;
        Node prev = head;
        while(cur != null && index >= 0){
            if(cur.len <= index) {
                index -= cur.len;
            }else{
                if(cur.len != 5){
                    for(int i = cur.len ; i > index; i--){
                        cur.chars[i] = cur.chars[i - 1];
                    }
                    cur.chars[index] = ch;
                    cur.len ++;
                }else{
                    Node nextNode = new Node();
                    nextNode.len = 1;
                    nextNode.chars[0] = cur.chars[4];//set cur last to new first
                    nextNode.next = cur.next;
                    cur.next = nextNode;
                    for(int i = cur.len - 1; i > index; i--){
                        cur.chars[i] = cur.chars[i - 1];
                    }
                    cur.chars[index] = ch;
                }
                System.out.println("Inserted char: " + cur.chars[index] + " at index of that node: " + index);
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        // append to last
        if(cur == null){
            Node tail = new Node();
            tail.len = 1;
            tail.chars[0] = ch;
            prev.next = tail;
            System.out.println("Inserted char: " + ch + " at index of that node: " + index);
        }
        totalLen++;
    }

    public void delete(int index){
        if(index < 0 || index >= totalLen || totalLen == 0){
            return;
        }
        Node cur = head;
        Node prev = new Node();
        prev.next = cur;
        while (cur != null && index >= 0){
            if(cur.len <= index){
                index -= cur.len;
            }else{
                if(cur.len == 1){
                    System.out.println("Deleted char: " + cur.chars[index] + " at index of that node: " + index);
                    prev.next = cur.next;
                }else{
                    System.out.println("Deleted char: " + cur.chars[index] + " at index of that node: " + index);
                    for(int i = index; i < cur.len - 1; i++){
                        cur.chars[i] = cur.chars[i + 1];
                    }
                    cur.len--;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        totalLen--;

    }

    public static void main(String[] args) {
        Node n1 = new Node(); //a b
        Node n2 = new Node(); //b
        Node n3 = new Node(); //a b c d e

        n1.chars[0] = 'a';
        n1.chars[1] = 'b';
        n2.chars[0] = 'b';
        n3.chars[0] = 'a';
        n3.chars[1] = 'b';
        n3.chars[2] = 'c';
        n3.chars[3] = 'd';
        n3.chars[4] = 'e';

        n1.next = n2;
        n2.next = n3;
        n1.len = 2;
        n2.len = 1;
        n3.len = 5;

        UnrolledLinkedList obj = new UnrolledLinkedList(n1);
        obj.insert('h',2);
        obj.insert('f',8);
        obj.delete(1);
        obj.delete(4);
    }
}
