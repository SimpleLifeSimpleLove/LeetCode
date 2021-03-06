package _0830_Positions_of_Large_Groups;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/1/5 9:44
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了43.77%的用户
 */
public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1, j = 0, cnt = 1; i < s.length(); i++) {
            while (i < s.length() && s.charAt(j) == s.charAt(i)) {
                i++;
                cnt++;
            }
            if (cnt >= 3) {
                List<Integer> r = new ArrayList<>();
                r.add(j);
                r.add(j + cnt - 1);
                res.add(r);
            }
            j = i;
            cnt = 1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).largeGroupPositions("abbxxxxzzy"));
        System.out.println((new Solution()).largeGroupPositions("abc"));
        System.out.println((new Solution()).largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
