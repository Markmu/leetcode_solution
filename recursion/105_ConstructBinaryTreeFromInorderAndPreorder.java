package recursion;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright && ileft > iright) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pleft]);
        if (pleft == pright && ileft == iright) {
            return node;
        }
        int midIndex = findMidIndex(inorder, ileft, iright, preorder[pleft]);
        int leftLength = midIndex - ileft;
        if (pleft > pright) {
            node.left = null;
        } else {
            node.left = helper(preorder, pleft + 1, pleft + leftLength, inorder, ileft, midIndex - 1);
        }
        if (ileft > iright || pleft + leftLength + 1 >= inorder.length) {
            node.right = null;
        } else {
            node.right = helper(preorder, pleft + leftLength + 1, pright, inorder, midIndex + 1, iright);
        }
        return node;
    }

    private int findMidIndex(int[] arr, int from, int to, int target) {
        for (int i = from; i <= to; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    } 
}