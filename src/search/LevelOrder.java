package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 */
public class LevelOrder {
     public  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {

    }
    public static int[] levelOrder(TreeNode root) {
         if(root == null){
            return new int[0];
         }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        queue.offer(root);
        while (queue.size()!=0) {
            TreeNode node = queue.poll();//先取出队首元素
            tmp.add(node.val);//将结点的值取出
            if(node.left != null){queue.offer(node.left);}//判断左节点的值是否为空，不为空则压入队列，实现根左右的压入和取出
            if(node.right != null){queue.offer(node.right);}
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
