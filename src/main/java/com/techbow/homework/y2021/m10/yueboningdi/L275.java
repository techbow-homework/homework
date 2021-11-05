//In the left of the h index, citations[index] < n - index; ON the right of the h index, citations[index] > n - index.
//The essence of this problem is to find the index to the right of the dividing line.
//That is, find the minimum index where citations[index] >= n - index.

public class L275 {
    public static int hIndex(int[] citations){
        //corner cases
        if (citations == null || citations.length == 0){
            return 0;
        }
        //normal case
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (citations[mid] == n - mid){
                return n - mid;
            }else if (citations[mid] < n - mid){
                left = mid;
            }else{  //citations[mid] > n - mid
                right = mid;
            }
        }
        //post processing check edges for target:
        //array.length == 0; array.length == 2; all elem <= target; all elem >= target
        if (citations[left] == n - left){
            return n - left;
        }else if (citations[right] == n - right){
            return n - right;
        }else if (citations[right] < n - right){    //!!!in all index, citations[index] < n - index; {0} / {0,0}
            return 0;
        }else if (citations[left] > n - left){  //in all index, citations[index] > n - index;
            return n - left;
        }else{  //normal case: citations[left] < n - left, citations[right] > n - right
            return n - right;
        }
    }

    public static void main(String[] args){
        int[] citations = {0,1,4,5,6};
        System.out.println(hIndex(citations));
    }
}
