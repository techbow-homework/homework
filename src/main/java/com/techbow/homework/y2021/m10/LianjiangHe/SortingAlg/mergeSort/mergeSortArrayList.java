//arrayLIst version
//out of boundary error still need to be fixed
import java.util.ArrayList;
import java.util.List;

public class mergeSortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3));

        System.out.println("Before sort:");
        ArrayUtils.printArray(arrayList);

        mergeSort(arrayList);

        System.out.println("After sort:");
        ArrayUtils.printArray(arrayList);
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayList) {
        if(arrayList == null || arrayList.size() == 0){
            return null;
        }
        ArrayList<Integer> sortedArray = mergeSort(arrayList, 0, arrayList.size() - 1);
        return sortedArray;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayList, int left, int right) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(left == right){
            res.add(arrayList.get(left));
            return res;
        }
        int mid = left + (right - left)/2;
        ArrayList<Integer> leftRes = mergeSort(arrayList, left, mid);
        ArrayList<Integer> rightRes = mergeSort(arrayList, mid+1, right);
        return merge(leftRes,rightRes);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftRes, ArrayList<Integer> rightRes) {
        int totalSize = leftRes.size()+rightRes.size();
        int size1 = leftRes.size();
        int size2 = rightRes.size();
        int mergeCount = 0;
        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> S = new ArrayList<>();

        while (mergeCount < totalSize){
            if(index1 == size1){
                for (int i = index2; i < size2; i++) {
                    S.add(rightRes.get(i));
                    mergeCount++;
                    index2++;
                }
            }
            else if(index2 == size2){
                for (int i = index1; i < size1; i++) {
                    S.add(rightRes.get(i));
                    mergeCount++;
                    index1++;
                }
            }
            else{
                int value1 = leftRes.get(index1);
                int value2 = rightRes.get(index2);

                if(value1 == value2){
                    S.add(leftRes.get(index1));
                    S.add(rightRes.get(index2));
                    mergeCount += 2;
                    index1++;
                    index2++;
                }else if (value1 < value2){
                    S.add(leftRes.get(index1));
                    mergeCount++;
                    index1++;
                } else if (value1 > value2) {
                    S.add(rightRes.get(index2));
                    mergeCount++;
                    index2++;
                }
            }
        }
        return S;
    }
    public static class ArrayUtils {
        public static void printArray(ArrayList<Integer> arrayList) {
            System.out.print("{");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
}



