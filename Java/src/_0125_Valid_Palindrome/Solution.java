package _0125_Valid_Palindrome;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();  // 全部转化为小写字母
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            while (i < s.length() && !isValidCharacter(s.charAt(i))) i++;
            if (i == s.length()) return true;  // 全部为非字母
            while (j > 0 && !isValidCharacter(s.charAt(j))) j--;
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    private boolean isValidCharacter(Character c) {

        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {

//        String s = "A man, a plan, a canal: Panama";  // true
        String s = ".,";  // true
        System.out.println((new Solution()).isPalindrome(s));
    }
}
