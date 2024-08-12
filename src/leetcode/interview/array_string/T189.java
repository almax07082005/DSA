package leetcode.interview.array_string;

public class T189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] sliceArray = new int[k];

        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            sliceArray[j]  = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = sliceArray[i];
        }
    }
}
