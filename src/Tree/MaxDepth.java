package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 */
public class MaxDepth {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxDepth(root);
    }

//    public int maxDepth(TreeNode root) {
//        if(root.left == null || root.right == null) return 0;
//        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
//    }

    public static int maxDepth(TreeNode root) {
         if(root == null) return 0;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<TreeNode> tmp;//存放每一层的结点
        nodes.add(root);
        int res = 0;
        while (!nodes.isEmpty()){
            tmp = new ArrayList<>();
            for (TreeNode node: nodes) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);

            }
            nodes = tmp;
            res++;
        }
        return res;
    }
}
