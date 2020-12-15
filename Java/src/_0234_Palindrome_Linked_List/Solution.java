package _0234_Palindrome_Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/23 10:13
 * Content:
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        // 第一步：将链表存放到 list 中
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 第二步：判断 list 是否回文
        int l = 0, r = list.size() - 1;
        while (l < r) {

            if (!list.get(l).equals(list.get(r)))  // 不能用 != ，例子[-129, -129]
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {

        // 创建链表，获取链表头结点
//        ListNode head = (new MyLinkedList(new int[]{1, 2})).getHead();  // false
        ListNode head = (new MyLinkedList(new int[]{1, 2, 2, 1})).getHead();  // true
        System.out.println((new Solution()).isPalindrome(head));
    }
}
