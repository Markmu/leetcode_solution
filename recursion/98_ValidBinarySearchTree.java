package recursion;

import tree.TreeNode;


class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer upper, Integer lower) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        
        return isValid(node.left, val, lower) && isValid(node.right, upper, val);
    }
}