package list;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class ReverseLinkedList {


    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }

    //     ListNode cur = head;
    //     ListNode next, prev = null;
    //     while (cur != null) {
    //         next = cur.next;
    //         cur.next = prev;
    //         prev = cur;
    //         cur = next;
    //     }
    //     return prev;
    // }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        newHead.next = head;
        head.next = null;
        return newHead;
    }
}