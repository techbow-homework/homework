package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * Reverse Words in a String II
 * Given a character array s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 * <p>
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 * <p>
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */
public class LC_186 {
    public void reverseWords(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }

        int slow = 0;
        int fast = slow;
        int flag = 0;
        int temp = 0;
        while (fast < s.length) {
            if (s[fast] != ' ') {
                fast++;
                continue;
            }
            flag = fast;
            // reverse word
            temp = (fast - slow + 1) / 2;
            for (int i = 0; i < temp; i++) {
                swap(s, slow++, --fast);
            }
            fast = flag + 1;
            slow = fast;
        }
        fast --;
        temp = (fast - slow + 1) / 2;
        for (int i = 0; i < temp; i++) {
            swap(s, fast--, slow++);
        }
    }

    private void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new LC_186().reverseWords(s);
        for (char each : s) {
            System.out.print(each);
        }
    }
}
