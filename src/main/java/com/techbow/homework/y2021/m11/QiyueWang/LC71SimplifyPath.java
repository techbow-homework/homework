package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC71SimplifyPath {
//     public String simplifyPath(String path) {
//         int n = path.length();
//         Deque<Character> stack = new LinkedList<>();
//         stack.offerLast('/');
//         int countDot = 0;
//         boolean asName = false;
//         for(int i = 0 ; i < n; i++){
//             char cur = path.charAt(i);
//             if(cur == '/'){
//                 if(asName){
//                     stack.offerLast(cur);
//                     countDot = 0;
//                     asName = false;
//                     continue;
//                 }
//                 if(stack.peekLast() == '/') continue;
//                 if(countDot == 1){
//                     stack.pollLast();
//                     countDot = 0;
//                     continue;
//                 }
//                 if(countDot == 2){
//                     stack.pollLast(); // pop 2 dots and 1 /
//                     stack.pollLast();
//                     stack.pollLast();
//                     while(!stack.isEmpty() && stack.peekLast() != '/'){ // pop last level dir
//                         stack.pollLast();
//                     }
//                     if(stack.isEmpty()){ // if polled out all
//                         stack.offerLast('/');
//                     }
//                     countDot = 0;
//                     continue;
//                 }

//             }else if(cur == '.'){
//                 if(stack.peekLast() != '/' && stack.peekLast() != '.'){
//                     asName = true;
//                 }
//                 countDot ++;
//             }else{
//                 countDot = 0;
//             }
//             stack.offerLast(cur);
//         }
//         // post processing dots
//         if(countDot == 1){
//             stack.pollLast();
//             countDot = 0;
//         }
//         if(countDot == 2){
//             stack.pollLast(); // pop 2 dots and 1 /
//             stack.pollLast();
//             stack.pollLast();
//             while(!stack.isEmpty() && stack.peekLast() != '/'){ // pop last level dir
//                 stack.pollLast();
//             }
//             if(stack.isEmpty()){ // if polled out all
//                 stack.offerLast('/');
//             }
//             countDot = 0;
//         }
//         //System.out.println(stack.toString());
//         // process res
//         if(stack.size() != 1 && stack.peekLast() == '/'){
//             stack.pollLast();
//         }
//         StringBuilder res = new StringBuilder();
//         for(char c : stack){
//             res.append(c);
//         }
//         return res.toString();
//     }

    // other's solution
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/")); // /home
        System.out.println(simplifyPath("/home//foo")); // /home/foo
        System.out.println(simplifyPath("/a/./b/../../c/")); // /c
    }

}
// time O(n) space O(n)
