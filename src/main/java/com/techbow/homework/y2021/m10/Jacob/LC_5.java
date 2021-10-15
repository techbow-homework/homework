package com.techbow.homework.y2021.m10.Jacob;

public class LC_5 {
    public String longestPalindrome(String s){
        if(s == null || s.length() == 0);
        int left = 0;
        int right = 0;//left 和right是用来表示最长的palindrom的头尾
        int l, r;
        for(int i = 0; i < s.length(); i++){
            l = i;
            r = i;
            //右边+1要小于s.length()不可以出界.  如左边到右边baaaab中间都是a的。
            // 相同的字母都是palindrome，一直走到不是相同字母的。
            while(r+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                r++;
                i++;
            } //左边要大于1，右边要小于s.length()边界. 和左边减1然后右边加1把baaaab把所有的a包里面。
            // 中间部分是palindrome，看左右一不一样，一样的话就包括进去，形成新的palindrome
            while(l > 0 && r < s.length() - 1 && s.charAt(l-1) == s.charAt(r+1)){
                l--;
                r++;
            }
            // 如果r 和 l 发现在 大于 已经发现的结果，更新
            if(r - l > right - left){
                right = r;
                left = l;
            }
        }
        return s.substring(left, right+1);
    }

}
