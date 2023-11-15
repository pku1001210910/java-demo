package top.moonstar.list;

class Node {
    int value;
    Node next;

    public Node(int v) {
        this.value = v;
    }

    public Node(int v, Node n) {
        this.value = v;
        this.next = n;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node currNode = head;
        for (int i = 1; i < 5; i++) {
            currNode.next = new Node(i);
            currNode = currNode.next;
        }

        currNode = reverse(head);
        while (currNode != null) {
            System.out.println(currNode.value);
            currNode = currNode.next;
        }
    }

    public static Node reverse(Node head) {
        Node prevNode = null;
        Node currNode = head;

        while (currNode != null) {
            Node next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }

        return prevNode;
    }
}