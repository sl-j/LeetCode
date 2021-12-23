package search;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null?true:recur(root.left,root.right);
    }
    public static boolean recur(TreeNode left,TreeNode right){
        if(left == null && right == null){return true;}//两者同时为空，则证明遍历到底都一样
        if(left == null || right == null || left.val != right.val){return false;}//只有一个为空证明不一样,左节点的值等于右节点的值时才相等
        return recur(left.left,right.right) && recur(left.right,right.left);
    }

}
