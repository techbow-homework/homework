package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;
public class LC658 {

/*option 1
直观解法,由于数组有序，所以最后找到的k个元素也一定是有序的，其实就是返回了一个长度为k的子数组，
相当于在长度为n的数组中去掉n-k个数字， 而且去掉的顺序肯定是从两头开始去，因为距离x最远的数字肯定在首尾出现。
每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止。
留下最近的,去掉最远的,直到数组长度为k
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     List<Integer> res=new ArrayList<>();
			 int len=arr.length;
			 int left=0;
			 int right=len-1;
			 while (len>k) {
				if (Math.abs(arr[left]-x)>Math.abs(arr[right]-x)) {
					left++;
				}else {
					right--;
				}
				len--;
			}
	        for (int index = left; index <=right; index++) {
	                  res.add(arr[index]);
			}
		     return res;
	    }
    }
/*option 2
* 
*
* */

//option 3
/*
* 题目要求求出一组数字，它们是与某个数字最为接近的一组数字。简单来讲，我们需要先找到最接近x的数字n，
* 最后的结果一定是数组中包含数字n的一个子数组。我们需要做的是不断地比较n两边的数字的同时，不断的扩大n两边的范围，直到范围长度等于k为止。
* */
/*

class Solution {
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> res=new ArrayList<>(); // 返回结果
    int left=findFirstSmallOrEqual(arr,x);// 找到第一个小于等于x的数字(并不是index)
    int right=left+1;// 第一个大于x的数字
    // 找到k个最接近x的数字
    while(k>0){
        // 如果左指针越界，右指针指向的数字是最接近x的
        // 将右指针指向的数字划入结果范围，右指针加一
        if(left<0) right++;
            // 如果右指针越界，左指针指向的数字是最接近x的
            // 将左指针指向的数字划入结果范围，左指针减一
        else if(right>=arr.length) left--;
        else{ // 两指针都没有越界
            // 如果左指针指向的数字与x的差值小于等于右指针与x的差值
            if((x-arr[left])<=(arr[right]-x)){
                // 将左指针指向的数字划入结果范围，左指针减一
                left--;
            }else{
                // 反之将右指针指向的数字划入结果范围，右指针加一
                right++;
            }
        }
        k--;
    }
    // 由于左右指针都多进行了一次加一减一操作，还原指针
    left++;
    right--;
    // 将区间内的数字加入返回结果
    for(int i=left;i<=right;i++){
        res.add(arr[i]);
    }
    return res;
}
    // 二分查找
    int findFirstSmallOrEqual(int[] arr, int x){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=x) low=mid+1;
            else high=mid-1;
        }
        return high>=0?high:0;
    }
}*/
/*      这道题给了一个数组,还有两个变量k和x.让找数组中离x最近的k个元素
        而且说明了数组是有序的,如果两个数字距离x相等的话,取较小的那个
        从给定的例子可以分析出x不一定是数组中的数字,由于数组是有序的,
        所以最后返回的k个元素也一定是有序的，那么其实就是返回了原数组的一个长度为k的子数组
        实际上相当于在长度为n的数组中去掉 n-k 个数字，而且去掉的顺序肯定是从两头开始去，因为距离x最远的数字肯定在首尾出现。
        每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止*/
}
/*option 4 brute force 把每个int丢进comparator里面比较,小的就放前面
//Time complexity: O(N⋅log(N)+k⋅log(k).
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Convert from array to list first to make use of Collections.sort()
        List<Integer> sortedArr = new ArrayList<Integer>();
        for (int num: arr) {
            sortedArr.add(num);
        }

        // Sort using custom comparator
        Collections.sort(sortedArr, new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                return Math.abs(num1 - x) - Math.abs(num2 - x);
            }
        });

        // Only take k elements
        sortedArr = sortedArr.subList(0, k);

        // Sort again to have output in ascending order
        Collections.sort(sortedArr);
        return sortedArr;
    }
}
*/