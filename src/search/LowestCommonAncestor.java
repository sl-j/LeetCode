package search;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;//找到p或q，返回这个结点，找不到则返回null

        /**
         * 查找pq是否都在左边或者右边，且返回值一定是第一个出现在左边或者右边的结点
         * 如果同在左边或者右边，则找到第一个就可以
         */
        TreeNode pqLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode pqRight = lowestCommonAncestor(root.right,p,q);

        if(pqLeft == null) return pqRight;//都不在左子树，则必在右边
        if(pqRight == null) return pqLeft;//都不在右子树，则必在左边

        return root;//不全在左边，也不全在右边，返回root
    }

//    private int k = 2;
//    private  TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//       k = 2;
//       dfs(root,p,q);
//       return res;
//    }
//
//    public void dfs(TreeNode node,TreeNode p,TreeNode q){
//        if(node == null) return;
//        int kOld = k;//记录每一个结点的k
//        if(node.val == p.val || node.val == q.val) k--;
//        dfs(node.left,p,q);
//        dfs(node.right,p,q);
//        /**
//         * 找到两个结点，回退后遇到的第一个kOld为2的结点为最近祖先节点，res==null是为了防止回退过程中，改变res的值
//         */
//        if(kOld == 2 && k == 0 && res == null){
//            res = node;
//        }
//    }
}
