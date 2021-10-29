package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;
//题目要求时间复杂度是O(log n),如果只用一次二分查找,那么最差情况所有的元素全部相等,往旁边traverse也会是线性的时间
//所以时间复杂度为n不能遍历.在寻找相同的数字边界的时候也要用二分查找
public class LC34 {
    //第一个自己做没用GitHub答案 Success 时间复杂度达标的题目,可喜可贺!
    class Solution {
        //if target found
        //return new int[]{lindex,rindex}

        //if target not found
        //return new int[]{-1,-1}
        public int[] searchRange(int[] nums, int target) {
            int l = 0;
            int r = nums.length-1;
            int existN = 0;

            int lindex = 0;//lindex.rindex都是存储最后一个符合条件的index
            int rindex = nums.length-1;

            while(l <= r){
                int m = (l+r)/2;
                if(nums[m]==target){//如果相等,那么表示肯定有一个值符合条件
                    lindex = m;//找最左边的那个值
                    r = m - 1;//如果找到了,那么不管右边了,看看左边能不能找到跟它一样的
                    existN++;//如果找到了就给它加个counter表示我找到了
                }else if(nums[m]<target)//如果中间的数比目标要小,那么target肯定在右边
                {
                    l = m + 1;//把左Pointer移到还没判断过的地方
                }else{
                    r = m - 1;//反之target在左边,把右Pointer往左移
                }
            }//while 循环结束,2分法找了一圈看看是不是有符合条件的答案
            if(existN == 0){//如果没有返回题目要求的{-1,-1}
                return new int[]{-1,-1};
            }else{//如果有那么就往右边找,初始化左右pointer,保证里面至少有一个值等于target
                l = lindex;
                r = nums.length-1;
                while(l <= r){
                    int m =  (l+r)/2;
                    if(nums[m]==target){//如果正中间的正好等于target,那么表示左边到lindex的值都等于target,看右边有没有符合条件的
                        rindex = m;//保存一个至少等于target的答案
                        l = m + 1;//左Pointer右移
                    }else{//没有符合条件的说明符合条件的在左边
                        r = m - 1;//右pointer左移
                    }
                }
                return new int[]{lindex,rindex};//返回答案
            }
        }
    }
}