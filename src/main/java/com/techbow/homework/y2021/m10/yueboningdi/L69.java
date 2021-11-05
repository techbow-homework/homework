//Derived from Algo Coach Session 1 Q6
//The essence of the problem is finding the maximum integer whose square is less than or equal to integer x.
//Binary search start at 0, for the end we can choose x.
public class L69 {
    public static int mySqrt(int x){
        int left = 0;
        //choose x as the right bond of binary search so that except for 1, sqrt of x must fall within (0,x].
        int right = x;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //!!!!!Caution!!! Avoid integer overflow!!!
            long square = (long) mid * mid;
            if (square == x){
                return mid;
            }else if (square < x){
                left = mid;
            }else{  //square > x
                right = mid;
            }
        }
        //postprocessing check edges for target
        if (left * left == x){  // x == 0
            return left;
        }else if (right * right == x){  //x == 1
            return right;
        }else{
            //no other corner cases like right^2 < x(all elements < sqrt(x))
            //or left^2 > x (all elements > sqrt(x))
            //because sqrt(x) must fall within [0,x]
            //normal case: left^2 < x, right^2 > x
            return left;
        }
    }

    public static void main(String[] args){
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }
}
