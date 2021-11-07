//arrayLIst version
public  List<Integer> mergeSort(ArrayList<Integer> array){
    if(array == null || array.size() == 0){
        return null;
        }
    ArrayList<Integer> sortedArray = mergeSort(array, 0, array.size() - 1);
        return sortedArray;
        }

private ArrayList<Integer> mergeSort(ArrayList<> array, int left, int right){
    List<Integer> res = new ArrayList<Integer>();
    if(left == right){
        res.add(array.get(left));
        return res;
        }
    int mid = left + (right - left)/2;
    ArrayList<Integer> leftRes = mergeSort(array, left, mid);
    ArrayList<Integet> rightRes = mergeSort(array, left, mid);
    return merge(leftRes, rightRes);
        }

private ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){

}