package dfs;

import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 */
public class TreeToDoublyList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(5);
        treeToDoublyList(node);
    }
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        ArrayList<Node> nodeValues = new ArrayList<>();
        dfs(root,nodeValues);
        Node head = nodeValues.get(0);
        Node pre = head;//前驱结点
        for (int i = 1; i < nodeValues.size(); i++) {
            pre.right = nodeValues.get(i);
            nodeValues.get(i).left = pre;
            pre = nodeValues.get(i);
;        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    //中序遍历
    public static void dfs(Node root,ArrayList<Node> nodeValues){
        if(root == null) return;
        dfs(root.left,nodeValues);
        nodeValues.add(root);
        dfs(root.right,nodeValues);
    }


}
