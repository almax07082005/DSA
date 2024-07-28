package leetcode.interview.array_string.t26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}
