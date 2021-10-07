package com.techbow.homework.y2021.m10.Sammy;

//public class NewCal {
//    public long calculate(List<String> input){
//        //cc
//        Stack<Character> stack = new Stack<>();
//        if(input.size() == 1){
//            if(Character.isDigit(input.get(0).charAt(0))){
//                return (long)input.get(0).charAt(0);
//            }
//        }
//        for(String e: input){
//            char cur = e.charAt(0);
//            if(Character.isDigit(cur)){
//                stack.push(cur);
//            } else {//operator
//
//                int num1 = stack.pop();
//                int num2 = stack.pop();
//                if(cur == '+'){
//                    stack.push((char)(num1 + num2));
//                }
//                else if(cur == '-'){
//                    stack.push((char)(num2 - num1));
//                }
//                else if(cur == '*'){
//                    stack.push((char)(num1 * num2));
//                }
//                else if(cur == '/'){
//                    stack.push((char)(num2 + num1));
//                }
//            }
//        }
//        if(stack.size() == 1) {
//            char res = stack.pop();
//            if(Character.isDigit(res)){
//                return (long)res;
//            }
//        } else {
//            return 0;
//        }
//    }
//}
