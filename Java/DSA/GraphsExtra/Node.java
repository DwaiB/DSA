package Java.DSA.GraphsExtra;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    public T val;
    public Map<Node<T>, Integer> neighbors;

    public Node(T item) {
        val = item;
        neighbors = new HashMap<Node<T>, Integer>();
    }

    public Node(T item, Map<Node<T>, Integer> _neighbors) {
        this.val = item;
        this.neighbors = _neighbors;
    }

    public void addNeighbor(Node<T> node) {
        neighbors.put(node, null);
    }

    public void addNeighbor(Node<T> node, int weight) {
        neighbors.put(node, weight);
    }
}