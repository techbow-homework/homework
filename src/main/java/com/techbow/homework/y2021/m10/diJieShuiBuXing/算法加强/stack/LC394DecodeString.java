package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */

//类似calculator，将数字和字符放在不同的stack里
public class LC394DecodeString {
    public static String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        int length = s.length();
        int i = 0;
        while(i < length){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int val = 0;
                while(i < length && s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                    val = 10 * val + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(val);
            }else if ( ch == '['){
                charStack.push(ch);
                i++;
            }else if (ch == ']'){
                decode(numStack, charStack);
                i++;
            }else{
                charStack.push(ch);
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()){
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }

    private static void decode(Stack<Integer> numStack, Stack<Character> charStack) {
        if(numStack.isEmpty()){
            return;
        }
        int times = numStack.pop();

        List<Character> subChars = new ArrayList<>();
        while(!charStack.isEmpty() && charStack.peek()!= '['){
            subChars.add(charStack.pop());
        }
        if(!charStack.isEmpty()){
            charStack.pop();
        }

        while(times-- > 0 ){
            for(Character ch : subChars){
                charStack.add(0,ch);
            }
        }
    }


    public static void main(String[] args) {
      String str =  "10[leetcode]";
      decodeString(str);
    }
}
