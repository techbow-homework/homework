//public class L702{
//    public static int search(ArrayReader reader, int target){   //TODO: long
//        //corner cases
//        if (reader.get(0) = null){ //length == 0
//            return -1;
//        }else if (reader.get(1) = null){   //length == 1
//            return (reader.get(0) == target)? 0 : -1;
//        }
//        //normal case
//        int left = 0;
//        int right = 1;
//        int mid = 0;
//        while (reader.get(right) != null && reader.get(right) < target){
//            left = right;
//            right *= 2;
//        }
//        while (left <= right){
//            mid = left + (right - left) / 2;
//            if (reader.get(mid) == null){
//                right = mid - 1;
//            }else if (reader.get(mid) == target){
//                return mid;
//            }else if (reader.get(mid) < target){
//                left = mid + 1;
//            }else{  //ArrayReader.get(mid) > target
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }
//}
