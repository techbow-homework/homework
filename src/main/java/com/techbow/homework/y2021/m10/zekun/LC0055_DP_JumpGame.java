package LC;

public class LC0055_DP_JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            //cc
            if(nums == null || nums.length < 1) return false;
            int l = nums.length;
            boolean[] dp = new boolean[l];

            dp[l-1] = true;
            for(int i = l - 2; i >= 0; i--){
                for(int j = 1; j <= nums[i]; j++){
                    if(i + j < l && dp[i + j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }

    }
}
