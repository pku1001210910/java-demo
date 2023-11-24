package top.moonstar.list;

import java.util.ArrayList;
import java.util.List;

/**
 * link:
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class FlattenList {
    /**
     * flattn linked list and return its tail
     * 
     * @param head
     * @return
     */
    public Node flattenHelperWithTail(Node head) {
        Node prevNode = null;
        Node currNode = head;
        while (currNode != null) {
            Node next = currNode.next;
            if (currNode.child == null) {
                prevNode = currNode;
                currNode = next;
                continue;
            }

            currNode.child.prev = currNode;
            currNode.next = currNode.child;
            Node childTailNode = flattenHelperWithTail(currNode.child);
            childTailNode.next = next;
            if (next != null) {
                next.prev = childTailNode;
            }
            currNode.child = null;
        }
        return prevNode;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node currNode = head;
        while (currNode != null) {
            Node next = currNode.next;
            Node child = currNode.child;
            if (child == null) {
                currNode = next;
                continue;
            }

            child = flatten(child);
            currNode.child = null;
            currNode.next = child;
            child.prev = currNode;

            while (child.next != null) {
                child = child.next;
            }

            if (next != null) {
                next.prev = child;
            }
            child.next = next;
        }

        return head;
    }
}
