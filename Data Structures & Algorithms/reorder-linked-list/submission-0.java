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
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode fast = head , slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if( fast == slow) return;

        ListNode mid = slow;
        ListNode first = head;
        ListNode second = reverse(mid.next);
        mid.next = null;
        while(first != null &&second != null){
            ListNode temp = first.next;

            first.next = second;
            second = second.next;

            first.next.next = temp;
            first = temp;
        
        }
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}
