package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    @Test
    public void test(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println();
    }


    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,nums.length,0,path,visited);
        return ans;
    }


    /**
     *
     * @param nums  原数组
     * @param length 数组的长度
     * @param depth 树的深度，当书的深度和长度相等时，返回path
     * @param path 每一次遍历时，将路径存储在path中
     * @param visited 如果访问过改结点，置为false
     */
    private void dfs(int[] nums, int length, int depth, List<Integer> path,boolean[] visited) {
        if(length == depth){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, length, depth + 1, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
