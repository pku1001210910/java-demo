package top.moonstar.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        new CloneGraph().cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> created = new HashMap<>();
        return cloneGraphHelper(node, created);
    }

    public Node cloneGraphHelper(Node node, Map<Integer, Node> created) {
        if (created.containsKey(node.val)) {
            return created.get(node.val);
        }

        Node newNode = new Node(node.val);
        created.put(newNode.val, newNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            Node newNeighbor = cloneGraphHelper(neighbor, created);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}
