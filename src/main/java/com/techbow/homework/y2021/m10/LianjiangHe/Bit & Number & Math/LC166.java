//You must implement a solution with a/linear runtime/complexity and use only
//constant extra space.
//a⊕0=a  ;  a⊕a=0  ; a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
