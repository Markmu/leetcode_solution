package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && node.left != cur 
                && (node.right == null || node.right != cur)) {
                stack.push(node.left);
                cur = node.left;
            } else if (node.right != null && node.right != cur) {
                stack.push(node.right);
                cur = node.right;
            } else {
                node = stack.pop();
                result.add(node.val);
                cur = node;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}