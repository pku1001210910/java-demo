package top.moonstar.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
class Node {
    public char val;
    Map<Character, Node> children = new HashMap<>();

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    final Map<Character, Node> children = new HashMap<>();

    public Trie() {
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        Map<Character, Node> child = children;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = child.get(ch);
            if (node == null) {
                node = new Node(ch);
            }
            child.put(ch, node);
            child = node.children;
        }
        child.put('.', new Node('.'));
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return true;
        }

        Map<Character, Node> child = children;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = child.get(ch);
            if (node == null) {
                return false;
            }
            child.put(ch, node);
            child = node.children;
        }

        return child.containsKey('.');
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }

        Map<Character, Node> child = children;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Node node = child.get(ch);
            if (node == null) {
                return false;
            }
            child.put(ch, node);
            child = node.children;
        }

        return true;
    }
}