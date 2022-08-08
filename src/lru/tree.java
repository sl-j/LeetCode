package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        TreeNode root = build(split);


    }

    //构建二叉树
    private static TreeNode build(String[] split) {
        List<TreeNode> list = new ArrayList<>();
        Collections.fill(list, null);
        TreeNode root = null;
        for(int i = 0; i < split.length; i++){
            TreeNode node = null;
            if(!split[i].equals("#")) node = new TreeNode(Integer.parseInt(split[i]));
            list.add(i,node);
            if(i == 0){
                root = node;
            }
        }
        for (int i = 0;  2 * i + 2 < split.length ; i++) {
            if(list.get(i) != null){
                list.get(i).left = list.get(2 * i + 1);
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return root;
    }
}
