package _0060_Permutation_Sequence;

import java.util.LinkedList;

/**
 * Date: 2020/9/5 10:07
 * Content:
 */
class Solution {
    private StringBuilder res;
    private int topK;
    private int count;
    private boolean[] used;

    private void generatePermutation(int[] nums, int index) {
        if (index == nums.length) {
            count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                res.append(nums[i]);
                generatePermutation(nums, index + 1);
                if (count == topK)
                    break;
                res.deleteCharAt(res.length() - 1);
                used[i] = false;
            }
        }
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;

        res = new StringBuilder();
        topK = k;
        used = new boolean[n];  // 默认false

        generatePermutation(nums, 0);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).getPermutation(3, 5));
        System.out.println((new Solution()).getPermutation(4, 9));
    }
}