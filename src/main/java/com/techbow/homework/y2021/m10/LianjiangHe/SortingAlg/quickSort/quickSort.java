//
import java.util.Random;

public class quickSort {
    public static class ArrayUtils {

        public static void printArray(int[] array) {
            System.out.print("{");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before sort:");
        ArrayUtils.printArray(array);

        quickSort(array);

        System.out.println("After sort:");
        ArrayUtils.printArray(array);
    }

    public static int[] quickSort(int[] array){
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        return array;
    }
    private static void quickSort(int[] array, int left, int right){
        if(left >= right) return;
        int pivotIdx = findPivotAndPartition(array, left, right);
        quickSort(array, left, pivotIdx-1);
        quickSort(array, pivotIdx+1, right);
    }

    private static int findPivotAndPartition(int[] array, int left, int right){
        int leftIdx = left;
        int rightIdx = right;
        Random rand = new Random();
        int pivot = left + rand.nextInt(right - left +1);
        int pivotVal = array[pivot];
        swap(array, pivot, right);
        rightIdx--;
        while(leftIdx <= rightIdx){
            if(array[leftIdx] <= pivotVal){
                leftIdx++;
            }else if(array[rightIdx] > pivotVal){
                rightIdx--;
            }else{
                swap(array, leftIdx++, rightIdx--);
            }
        }
        swap(array, leftIdx, right);
        return leftIdx;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}