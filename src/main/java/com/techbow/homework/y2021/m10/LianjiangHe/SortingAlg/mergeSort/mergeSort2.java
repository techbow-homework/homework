public class mergeSort2 {

    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before sort:");
        ArrayUtils.printArray(array);

        mergeSort(array);

        System.out.println("After sort:");
        ArrayUtils.printArray(array);
    }

    public static void mergeSort(int[] array) {
        sortArray(array, 0, array.length - 1);
    }

    private static void sortArray(int[] array, int start, int end) {
        // 单个元素不需要排序,直接返回
        if (start == end) {
            return;
        }
        int separate = start + (end-start)/2;

        sortArray(array, start, separate);//两个subarray  递归排序左边的S1
        sortArray(array, separate + 1, end);//递归排序右边的S2

        mergeArray(array, start, separate, end);//merge S1 S2
    }

    private static void mergeArray(int[] array, int start, int seperate, int end) {
        int totalSize = end - start + 1;
        int size1 = seperate - start + 1;
        int size2 = end - seperate;

        int[] array1 = new int[size1];
        int[] array2 = new int[size2];

        //把S1 S2拆开放在array1 和 array2 里
        for (int i = 0; i < size1; i++) {
            array1[i] = array[start + i];
        }

        for (int i = 0; i < size2; i++) {
            array2[i] = array[seperate + 1 + i];
        }

        int mergeCount = 0;
        int index1 = 0;
        int index2 = 0;

        while (mergeCount < totalSize) {//在merge数小于总数前
            // 先检查有没有其中的一个数组已经处理完
            if (index1 == size1) {//如果S1没有元素了,那么把S2里的全部元素加到array里
                for (int i = index2; i < size2; i++) {
                    array[start + mergeCount] = array2[i];
                    mergeCount++;
                    index2++;
                }
            } else if (index2 == size2) {//如果S2没有元素了,把S1全部加进去
                for (int i = index1; i < size1; i++) {
                    array[start + mergeCount] = array1[i];
                    mergeCount++;
                    index1++;
                }
            } else {
                int value1 = array1[index1];//value1 是S1中的最小值
                int value2 = array2[index2];//value2 是S2中的最小值

                if (value1 == value2) {//两个子序列最小值相等就都丢进S里去了
                    array[start + mergeCount] = value1;
                    array[start + mergeCount + 1] = value1;
                    mergeCount += 2;//融合了2次
                    index1++;//左右idx各+1
                    index2++;
                } else if (value1 < value2) {//如果S1<S2
                    array[start + mergeCount] = value1;//S1加进去
                    mergeCount++;
                    index1++;
                } else if (value1 > value2) {//反之S2
                    array[start + mergeCount] = value2;
                    mergeCount++;
                    index2++;
                }
            }
        }
    }
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

}
