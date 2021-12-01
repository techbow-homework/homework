/*
L50. Pow(x, n)
 */
public class L50 {
    public static double myPow_sol0_0(double x, int n){
        //corner case
        if (x == 0.0){
            return 0;
        }
        if (n == 0){
            return 1;
        }
        //normal case
        int helperN = n;
        if (n < 0){
            helperN = -helperN;
        }
        double ans = 1;
        for (int i = 0; i < helperN; i++){
            ans *= x;
        }
        if (n < 0){
            ans = 1 / ans;
        }
        return ans;
    }

    public static double myPow_sol0_1(double x, int n){
        //corner case
        if (x == 0.0){
            return 0;
        }
        if (n == 0){
            return 1;
        }
        double ans = 0;
        if (n > 0){
            ans = myPow_sol0_1_helper(x,n);
        }else{  // n<0
            ans = 1 / myPow_sol0_1_helper(x, -n);
        }
        return ans;
    }

    public static double myPow_sol0_1_helper(double x, int n){
        //base case
        if (n == 1){
            return x;
        }
        //normal case
        return x * myPow_sol0_1_helper(x, n - 1);
    }

    //solution 1: binary reduction recursion solution
    public static double myPow_sol1(double x, int n) {
        //corner case
        if (x == 0.0){
            return 0;
        }
        if (n == 0){
            return 1;
        }
        double ans = 0;
        if (n > 0){
            ans = myPow_sol1_helper(x,n);
        }else{  // n<0
            ans = 1 / myPow_sol1_helper(x, -n);
        }
        return ans;
    }

    public static double myPow_sol1_helper(double x, int n) {
        //base case
        if (n == 1){
            return x;
        }

        return myPow_sol1_helper(x, n / 2) * myPow_sol1_helper(x, n - n / 2);
    }

    //solution 2: dp recursion solution
    public static double myPow_sol2(double x, int n) {
        //corner case
        if (x == 0.0){
            return 0;
        }
        if (n == 0){
            return 1;
        }
        //The following line is the key point!!!
        // if n is int, when n==Integer.MINVALUE, -n stays the same.
        //This will lead to bugs.
        long N = n;
        double ans = 0;
        if (N > 0){
            ans = myPow_sol2_helper(x,N);
        }else{  // n<0
            ans = 1 / myPow_sol2_helper(x, -N);
        }
        return ans;
    }

    public static double myPow_sol2_helper(double x, long N) {
        //base case
        if (N == 1){
            return x;
        }
        double half = myPow_sol2_helper(x, N / 2);
        return (N % 2 == 0)? half * half: half * half * x;
    }

    public static void main(String[] args){
        double x = 1.0000;
        int n = -2147483648;
//        double x = 0.00001;
//        int n = -10;
//        System.out.println(myPow_sol0_0(x,n));
//        System.out.println(myPow_sol0_1(x,n));
//        System.out.println(myPow_sol1(x,n));
        System.out.println(myPow_sol2(x,n));
    }
}
