package dfs;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class KthLargest {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;

    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
