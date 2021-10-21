package com.techbow.homework.y2021.m10.QiyueWang;
import java.util.*;
// DRW OA
public class WordStackMachine {

    public static int solution(String S) {
        // write your code in Java SE 8
        String[] sArr = S.split(" ");
        //System.out.println(Arrays.toString(sArr));
        Deque<Integer> stack = new LinkedList<>();
        for(String s : sArr){
            if(stack.isEmpty()){
                if(s.equals("DUP") || s.equals("POP") || s.equals("+") || s.equals("-")){
                    return -1;
                }else{
                    int cur = Integer.parseInt(s);
                    stack.offerLast(cur);
                }
            }else{
                //System.out.println(stack);
                int top = stack.peekLast();
                if(s.equals("DUP")){
                    stack.offerLast(top);
                }else if(s.equals("POP")){
                    stack.pollLast();
                }else if(s.equals("+")){
                    int add1 = stack.pollLast();
                    if(stack.isEmpty()) return -1;
                    int add2 = stack.pollLast();
                    stack.offerLast(add1 + add2);
                }else if(s.equals("-")){
                    int subtract1 = stack.pollLast();
                    if(stack.isEmpty() || stack.peekLast() > subtract1) {
                        return -1;
                    }int subtract2 = stack.peekLast();
                    //System.out.println(subtract1 - subtract2);
                    stack.offerLast(subtract1 - subtract2);
                }else{
                    int cur = Integer.parseInt(s);
                    stack.offerLast(cur);
                }
            }



        }
        return stack.peekLast();
    }

    public static void main(String[] args) {
        String S = "4 5 6 - 7 +";
        System.out.println(solution(S));
    }


}
