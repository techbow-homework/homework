//Wtten by yueboningdi 20210301 in 10/13/2021

import java.util.ArrayList;
import java.util.List;

//My solution（这个solution虽然跑过了但是写的很幼稚，代码细节优化空间很大）
//调用的findClosest函数假设input array里面target没有重复，如果有的话会有bug
//arr ⇒ nums, k ⇒ k, x ⇒ target.

public class L658 {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //corner case
        if (arr == null || arr.length == 0){
            return null;
        }
        if (arr.length <= k){
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < arr.length; i++){
                res.add(arr[i]);
            }
            return res;   //convert an array to arraylist: Arrays.asList(arrName)???
        }
        //normal case
        List<Integer> res = new ArrayList<>();
        int closest = findClosest(arr, x);
        //resLeft and resRight is the index of unexpolred elements
        int resLeft = closest - 1;
        int resRight = closest + 1;
        int resCnt = 1;
        while (resLeft >= 0 && resRight < arr.length && resCnt < k){
            if (Math.abs(arr[resLeft] - x) <= Math.abs(arr[resRight] - x)){
                resLeft--;
                resCnt++;
            }else{
                resRight++;
                resCnt++;
            }
        }
        if (resCnt < k){
            //jump out while loop because resLeft overflow
            if (resLeft < 0){
                while (resRight < arr.length && resCnt < k){
                    resRight++;
                    resCnt++;
                }
            }
            //jump out while loop because resRight overflow
            if (resRight >= arr.length){
                while (resLeft >= 0 && resCnt < k){
                    resLeft--;
                    resCnt++;
                }
            }
        }
        //resCnt == k now, copy corresponding elements to res
        for (int i = 0; i < k; i++){
            res.add(arr[resLeft + 1 + i]);
        }
        return res;

    }

    public static int findClosest(int[] arr, int x){
        //corner case
        if (arr == null || arr.length == 0){
            return -1;
        }
        //normal case
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (arr[mid] == x){
                return mid;
            }else if (arr[mid] < x){
                left = mid;
            }else{	//arr[mid] > x
                right = mid;
            }
        }
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)? left : right ;
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,0,0,1,3,5,6,7,8,8};
        int k = 2;
        int x = 2;
        List<Integer> res= findClosestElements(arr,k,x);
        System.out.println("Results: ");
        for (Integer ele : res){
            System.out.println(ele);
        }
    }
}
