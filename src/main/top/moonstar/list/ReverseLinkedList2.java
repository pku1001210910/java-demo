package top.moonstar.list;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int v) {
        this.val = v;
    }

    public ListNode(int v, ListNode n) {
        this.val = v;
        this.next = n;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode currNode = head;
        // for (int i = 2; i < 6; i++) {
        // currNode.next = new ListNode(i);
        // currNode = currNode.next;
        // }

        currNode = reverseBetween(head, 1, 2);
        while (currNode != null) {
            System.out.println(currNode.val);
            currNode = currNode.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = head;
        ListNode leftBoundaryNode = null;

        int pos = 1;
        ListNode prevNode = null;
        ListNode currNode = head;
        while (pos <= left) {
            leftNode = currNode;
            leftBoundaryNode = prevNode;
            ListNode next = currNode.next;
            prevNode = currNode;
            currNode = next;
            pos++;
        }

        while (pos <= right) {
            ListNode next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
            pos++;
        }

        leftNode.next = currNode;
        if (leftBoundaryNode != null) {
            leftBoundaryNode.next = prevNode;
        } else {
            head = prevNode;
        }

        return head;
    }
}