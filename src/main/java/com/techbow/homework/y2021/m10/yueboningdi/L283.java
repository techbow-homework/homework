import java.util.Arrays;

/*
L283 Move zeros
 */
public class L283 {
    public static void moveZeroes(int[] nums){
        //corner case
        if (nums == null || nums.length == 0){
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[fast] == 0) fast++;
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        //till this point, slow locates in the start position of all the 0s
        //fill 0s in all remaining elements
        while (slow < nums.length){
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
