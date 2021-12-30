package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }
    LinkedList<List<Integer>> res= new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
       dfs(root,target);
       return res;
    }
    public void dfs(TreeNode root,int target){
        if(root == null) return;//当前结点为空直接返回
        path.add(root.val);//将当前结点的值存入路径中
        target -= root.val;//将目标值减去当前结点值，不断更新目标值
        if(root .left == null && root.right == null && target == 0){
            res.add(new LinkedList(path));//此处使用new LinkedList(path)，而不是直接add(path),是复制路径
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.removeLast();
    }
}
