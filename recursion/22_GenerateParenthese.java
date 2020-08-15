package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GenerateParenthese {

    class Node {
        String p;
        int left;
        int right;
        Node(String p, int left, int right) {
            this.p = p;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == n && node.right == n) {
                result.add(node.p);
            }
            if (node.left < n) {
                queue.offer(new Node(node.p + "(", node.left + 1, node.right));
            }
            if (node.left > node.right) {
                queue.offer(new Node(node.p + ")", node.left, node.right + 1));
            }
        }
        return result;
    }


    public List<String> _generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, result, "", n);
        return result;
    }

    private void generate(int left, int right, List<String> result, String s, int n) {
        if (left == right && right == n) {
            result.add(s);
        }
        if (left < n) {
            generate(left + 1, right, result, s + "(", n);
        }
        if (right < left) {
            generate(left, right + 1, result, s + ")", n);
        }
    }
}