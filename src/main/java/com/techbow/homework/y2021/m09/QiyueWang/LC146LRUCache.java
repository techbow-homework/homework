package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.HashMap;
import java.util.Map;

class DNode{
    int key;
    int val;
    DNode prev;
    DNode next;
    public DNode() {}
    public DNode(int k, int v){
        key = k;
        val = v;
        prev = null;
        next = null;
    }
}

class DList{
    DNode head;
    DNode tail;
    int size;
    public DList(){
        head = null;
        tail = head;
        size = 0;
    }

    public void offerLast(DNode dn){
        if(head == null){
            head = dn;
            tail = dn;
        }else{
            tail.next = dn;
            dn.prev = tail;
            tail = dn;
            //System.out.println(tail.key);
        }
        size++;
    }

    public DNode pollFirst(){
        if(head == null) return null;
        DNode dn = head;
        remove(head);
        return dn;
    }

    public void remove(DNode dn){
        if(dn == head && dn == tail){
            head = null;
            tail = null;
        }else if(dn == head){
            DNode temp = head.next;
            head.next = null;
            temp.prev = null;
            head = temp;
            //System.out.println(dn.key);
        }else if(dn == tail){
            DNode temp = tail.prev;
            tail.prev = null;
            temp.next = null;
            tail = temp;
        }else{
            DNode temp = dn.prev;
            dn.prev = null;
            temp.next = dn.next;
            dn.next.prev = temp;
            dn.next = null;
        }
        size --;
    }

    public int size(){
        return size;
    }
}


public class LC146LRUCache {

    int cap;
    Map<Integer, DNode> m;
    DList cache;

    public LC146LRUCache(int capacity) {
        cap = capacity;
        m = new HashMap<>();
        cache = new DList();
    }

    public int get(int key) {
        if(!m.containsKey(key)) return -1;
        int curVal = m.get(key).val;
        put(key, curVal);
        return curVal;
    }

    public void put(int key, int value) {
        DNode cur = new DNode(key, value);
        if(m.containsKey(key)){
            //System.out.println(key);

            cache.remove(m.get(key));
            cache.offerLast(cur);
            m.put(key, cur);
        }else{
            if(cache.size() == cap){
                DNode temp = cache.pollFirst();
                //System.out.println(temp.key);
                m.remove(temp.key);
            }
            cache.offerLast(cur);
            m.put(key, cur);
        }
        //System.out.println(m);
    }

    public static void main(String[] args) {
        //--------------------------
        int cap = 2;
        LC146LRUCache obj = new LC146LRUCache(cap);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println( obj.get(1));
        obj.put(3,3);
        System.out.println( obj.get(2));
        obj.put(4,4);
        System.out.println( obj.get(1));
        System.out.println( obj.get(3));
        System.out.println( obj.get(4));
        // 1, -1, -1, 3, 4
        //----------------------------
    }
}