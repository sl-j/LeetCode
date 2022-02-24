package ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * 你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 */
public class LevelOrder {

    public static class TreeNode {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int currentQueueLen = queue.size();
            for (int i = 0; i < currentQueueLen; i++) {//为什么要加这一个for，因为每一层可能有很多结点，这一层有多少结点，就要从队列中取出多少元素
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(tmp);
        }
        return ans;

    }

//    static List<List<Integer>> ans = new ArrayList<>();//存储答案
//
////    public static List<List<Integer>> levelOrder(TreeNode root) {
////        if(root == null) return ans;
////        helper(root,0);
////        return ans;
////    }
//
//    /**
//     *递归方案
//     * @param node  当前结点
//     * @param level  当前层数
//     */
//    public static void helper(TreeNode node,int level){
//        if(ans.size() == level) ans.add(new ArrayList<>());//如果ans的大小和level相等，即到了这一层，在ans中新建一个Arraylist（这时为空）
//
//        List<Integer> list = ans.get(level);//获取当前这一层的容器
//        list.add(node.val);//将这一层的值存入容器中
//
//        if(node.left != null) helper(node.left,level + 1);
//        if(node.right != null) helper(node.right,level + 1);
//    }


}
