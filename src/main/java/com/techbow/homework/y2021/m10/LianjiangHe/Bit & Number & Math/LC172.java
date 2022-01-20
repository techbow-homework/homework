//option 1 time limit exceeded
import java.math.BigInteger;
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        BigInteger Fac = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            Fac = Fac.multiply(BigInteger.valueOf(i));
        }
        while(Fac.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            Fac = Fac.divide(BigInteger.TEN);
            res += 1;
        }
        return res;
    }
}
//option 2
