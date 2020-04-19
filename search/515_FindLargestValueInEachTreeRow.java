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
}