package _0330_Patching_Array;

/**
 * Date: 2020/12/29 10:13
 * Content:
 * https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
 * 执行用时：1 ms, 在所有 Java 提交中击败了10.42%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了65.26%的用户
 */
public class Solution {

    public int minPatches(int[] nums, int n) {

        int res = 0;
        long x = 1;
        int len = nums.length, index = 0;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3};
        int n = 6;
        System.out.println((new Solution()).minPatches(nums, n));
    }
}