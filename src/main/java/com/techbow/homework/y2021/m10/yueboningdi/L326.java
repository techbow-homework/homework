/*
L326. Power of Three
 */
public class L326 {
    public static boolean isPowerOfThree(int n){
        //corner case
        if (n <= 0) return false;
        //base case
        if (n == 1) return true;
        //normal case
        if (n % 3 != 0) return false;
        else{
            return isPowerOfThree(n / 3);
        }
    }
}
