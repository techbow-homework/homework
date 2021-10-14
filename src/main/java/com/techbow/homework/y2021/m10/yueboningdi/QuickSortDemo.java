public class QuickSortDemo {
    public static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //print array function
    public static void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void quickSort(int[] arr, int begin, int end){
        if (arr == null || arr.length == 0){
            return;
        }
        int sortLength = end - begin + 1;
        //base case
        if (begin >= end){
            return;
        }
        int pivot = arr[end];
        int left = begin;
        int right = end - 1;
        while (left <= right){
            if (arr[left] < pivot){
                left++;
                continue;
            }
            if (arr[right] >= pivot){
                right--;
                continue;
            }
            swap(arr, left, right);
        }
        //At this point, left point to the leftmost value greater than pivot
        //At this point, right point to the rightmost value less than pivot
        //put pivot in the right place
        swap(arr, left, end);
        //recursively solve left and right halves
        quickSort(arr, begin, left - 1);
        quickSort(arr, left + 1, end);
    }
    public static void main(String args[]) {
        int numbers[] = {10,5,74,7,96,46,76,11};
        int testSize = 8;
        System.out.println("Unsorted array:\n");
        printArray(numbers);
        quickSort(numbers,0,testSize - 1);
        System.out.println("Sorted array:\n");
        printArray(numbers);
    }
}
