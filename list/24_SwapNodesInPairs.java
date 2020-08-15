package list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dommy = new ListNode(0);
        dommy.next = head;

        ListNode prev = dommy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode nextPair = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = nextPair;
            prev = cur;
            cur = nextPair;
        }
        return dommy.next;
    }
}