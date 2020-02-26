package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.addFirst(node.val);
            for (int i = 0; i < node.children.size(); --i) {
                Node cur = node.children.get(i);
                if (cur != null) {
                    stack.push(cur);
                }
            }
        }
        return result;
    }
}