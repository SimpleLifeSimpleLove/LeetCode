package _0023_Merge_k_Sorted_Lists;

/**
 * Date: 2020/9/20 14:42
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了76.22%的用户
 * 内存消耗：40.7 MB, 在所有 Java 提交中击败了12.53%的用户
 */
public class Solution {

    // 返回l1和l2合并后链表的头结点
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        for (int step = 1; step < lists.length; step += step)  // 每次合并的两个链表的索引差值
            for (int i = 0; i + step < lists.length; i += (step + step))  // i 代表两个待合并链表中的第一个
                lists[i] = mergeTwoList(lists[i], lists[i + step]);  // list[i] 和 list[i+step] 进行合并
        return lists[0];
    }

    public static void main(String[] args) {

//        // 创建链表，获取链表头结点
//        ListNode l1 = (new MyLinkedList(new int[]{1, 4, 5})).getHead();
//        ListNode l2 = (new MyLinkedList(new int[]{1, 3, 4})).getHead();
//        ListNode l3 = (new MyLinkedList(new int[]{2, 6})).getHead();
//        ListNode[] lists = {l1, l2, l3};
        ListNode l1 = (new MyLinkedList(new int[]{})).getHead();
        ListNode l2 = (new MyLinkedList(new int[]{1})).getHead();
        ListNode[] lists = {l1, l2};
        ListNode l = (new Solution()).mergeKLists(lists);
        MyLinkedList.printLinkedList(l);
    }
}
