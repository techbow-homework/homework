package com.techbow.homework.y2021.m10.zekun;

public class LC0151_String_ReverseString {
    public static void main(String[] args){
        String s = "the sky is blue";
        LC0151_String_ReverseString sol = new LC0151_String_ReverseString();
        String res = sol.reverseWords(s);
        System.out.println(res);

    }

    public String reverseWords(String s) {
        //cc
        if(s == null || s.length() <= 1) return s;
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        String trim = trimSpaces(charArray);

        int slow = 0;
        char[] tmp = trim.toCharArray();
        reverse(tmp, 0, tmp.length - 1);

        for(int fast = 0; fast < trim.length(); ++fast){
            if(trim.charAt(fast) != ' '){
                continue;
            }

            reverse(tmp, slow, fast);
            fast++;
            slow = fast + 1;

        }

        return tmp.toString();

    }

    private void reverse(char[] ch, int left, int right){
        //base case
        if(left >= right) return;
        swap(ch, left, right);
        reverse(ch, left + 1, right - 1);
    }

    private void swap(char[] ch, int left, int right){
        char tmp = ' ';
        tmp = ch[left];
        ch[left] = ch[right];
        ch[right] = tmp;
    }
    public String trimSpaces(char[] chararray) {
        int left = 0, right = chararray.length - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && chararray[left] == ' ') {
            left++;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && chararray[right] == ' ') {
            right--;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = chararray[left];

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            left++;
        }
        return sb.toString();
    }
}
