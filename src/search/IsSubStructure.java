package search;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubStructure {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
          return ((A != null && B != null)   //判断的首要条件，a或b不能为空
          && (judge(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B)));//第一个：判断a为根节点的树，是否包含树b；第二和第三个：分别判断左右子树是否包含b树
    }
    public Boolean judge(TreeNode A, TreeNode B){
          if(B == null){return true;} //b树为空，则证明遍历完毕
          if(A == null || A.val != B.val) return false;//a为空，b不为空，则不为子树
          return judge(A.left,B.left) && judge(A.right,B.right);

    }
}
