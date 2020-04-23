package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int sum = Integer.MIN_VALUE;
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                sum = Math.max(node.val, sum);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum);
        }
        return result;
    }

    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(root.val);
        }
        if (result.get(level) < root.val) {
            result.set(level, root.val);
        }
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }
}