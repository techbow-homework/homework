/*
L231. Power of Two
 */
public class L231{
    //recursion solution
    public static boolean isPowerOfTwo_sol1(int n){
        //corner case
        if (n <= 0) return false;
        //normal case
        if (n == 1){
            return true;
        }
        if (n % 2 != 0){
            return false;
        }else{  //n%2==0
            return isPowerOfTwo_sol1(n / 2);
        }
    }

    //loop solution
    public static boolean isPowerOfTwo_sol2(int n) {
        //corner case
        if (n <= 0) return false;
        //normal case
        int N = n;
        while (N % 2 == 0 && N > 1){
            N /= 2;
        }
        return (N == 1)? true : false;
    }
}
