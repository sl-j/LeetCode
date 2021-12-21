package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 */
public class LevelOrder2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//先将root入队
        while (queue.size() != 0){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size();i > 0;i--) {//不可以用i++，因为size会随着出队不断变化，需要开始就将长度存储在变量中
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){queue.offer(node.left);};
                if(node.right != null){queue.offer(node.right);};//左右结点入队，但是队列长度存储在变量中，所以跳出for循环
            }
            res.add(tmp);
        }
        return res;

    }
}
