package recursion;

import java.util.Arrays;
import java.util.LinkedList;

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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);
        return sb.toString();
    }

    public void serializeHelper(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serializeHelper(sb, root.left);
        serializeHelper(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return deserializeHelper(new LinkedList<>(Arrays.asList(values)));
    }

    public TreeNode deserializeHelper(LinkedList<String> values) {
        if ("null".equals(values.getFirst())) {
            values.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(values.pollFirst()));
        root.left = deserializeHelper(values);
        root.right = deserializeHelper(values);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));