class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        int cur = 1;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                ans += (prev < cur ? prev : cur);
                prev = cur;
                cur = 1;
            }else{
                cur ++;
            }
        }
        return ans + (prev < cur ? prev : cur);
    }
}