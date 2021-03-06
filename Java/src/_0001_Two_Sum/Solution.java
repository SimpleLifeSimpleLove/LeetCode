package _0001_Two_Sum;

import _0000_study._common.Output;

/**
 * 暴力解法
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = (new Solution()).twoSum(nums, target);

        Output.OutputBasicArray1D(res);
    }
}