package com.techbow.homework.y2021.m10.jiale.other;

/**
 * Example: “yougetoffer”  remove f and o, then return “yugeter”
 * idea: two pointers, 0-slow is string with no f and o, slow to fast is checked, and fast to input.length is unchecked
 */
public class RemoveCharsFromString {
    public String remove(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        int slow = 0;
        char[] chars = input.toCharArray();
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != 'o' && chars[fast] != 'f') {
                chars[slow++] = chars[fast];
            }
        }
        return new String(chars,0, slow);
    }

    public static void main(String[] args) {
        String input = "yougetoffer";
        System.out.println(new RemoveCharsFromString().remove(input));
    }
}
