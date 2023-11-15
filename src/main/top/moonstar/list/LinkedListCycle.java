package top.moonstar.list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * link: https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode == slowNode) { // there is a cycle!
                ListNode p1 = head;
                ListNode p2 = slowNode;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
