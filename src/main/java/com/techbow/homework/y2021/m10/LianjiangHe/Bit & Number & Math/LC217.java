class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>(nums.length);
        for (int x : nums){
            if(hashset.contains(x)){
                return true;
            }
            hashset.add(x);
        }
        return false;
    }
}