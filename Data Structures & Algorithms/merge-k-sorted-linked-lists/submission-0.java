/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j)
            return lists[i];
        int mid = i + (j - i) / 2;
        ListNode left = merge(lists, i, mid);
        ListNode right = merge(lists, mid + 1, j);
        return mergeNode(left, right);
    }
    private ListNode mergeNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (left != null && right != null) {
            ListNode temp;
            if (left.val < right.val) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        if (right != null) {
            curr.next = right;
        }
        if (left != null) {
            curr.next = left;
        }
        return dummy.next;
    }
}
