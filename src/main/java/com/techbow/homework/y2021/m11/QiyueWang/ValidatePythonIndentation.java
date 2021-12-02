package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class ValidatePythonIndentation {
    public boolean validate(String[] lines){
        int n = lines.length;
        Deque<String> stack = new LinkedList<>();
        for(int i =0; i < n; i++){
            int curIndent = getIndent(lines[i]);
            if(stack.isEmpty()){ // starting line
                if(curIndent != 0){
                    return false;
                }
            }
            //check for ':' case
            else if(stack.peekLast().charAt(stack.peekLast().length() - 1) == ':'){
                if(getIndent(stack.peekLast()) != curIndent - 1){
                    return false;
                }
            }else{
                while(!stack.isEmpty() && getIndent(stack.peekLast()) > curIndent){
                    stack.pollLast();
                }
                // stack must not be empty here
                if(getIndent(stack.peekLast()) != curIndent){
                    return false;
                }
            }
            stack.offerLast(lines[i]);
        }
        return true;
    }
    private int getIndent(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                res++;
            }else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ValidatePythonIndentation obj = new ValidatePythonIndentation();
        String[] lines = new String[]{
                "def:",
                " abc:",
                "  bc",
                "  cc",
                "   acc",
                " bcc",
                "asd"};
        System.out.println(obj.validate(lines));
        String[] lines2 = new String[]{
                "def:",
                " abc:",
                "  bc",
                "  cc",
                " acc",
                " bcc",
                "asd"};
        System.out.println(obj.validate(lines2));
    }
}
