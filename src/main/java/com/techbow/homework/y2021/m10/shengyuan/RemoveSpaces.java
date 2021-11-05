package com.techbow.homework.y2021.m10.shengyuan;

import java.util.Scanner;

public class RemoveSpaces {
    public String normalizeSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            //取的條件
            if (array[fast] != '_' || (fast != 0 && array[fast - 1] != '_')) {
                array[slow++] = array[fast];
            }
        }
        //post-processing
        if (slow == 0) {
            return "";
        }
        if (array[slow - 1] == '_') {
            return new String(array, 0, slow - 1);
        } else {
            return new String(array, 0, slow);
        }
    }
    public static void main(String[] args) {
        RemoveSpaces test = new RemoveSpaces();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your input: ");
        String input = sc.nextLine();
        String result = test.normalizeSentence(input);
        System.out.println(result);
    }
}
