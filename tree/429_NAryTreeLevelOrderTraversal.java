package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                Node node = queue.poll();
                line.add(node.val);
                for (int j = 0; j < node.children.size(); ++j) {
                    if (node.children.get(j) != null) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            result.add(line);
        }
        return result;
    }
}