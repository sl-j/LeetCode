package dfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {

    @Test
    public void ttest(){
        int i = numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}});
        System.out.println(i);
    }

//    public int numIslands(char[][] grid) {
//        int row = grid.length;//行数
//        int clo = grid[0].length;//列数
//        int ans = 0;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < clo; j++) {
//                if(grid[i][j] == '1'){//如果为1，则证明有岛屿，
//                    ans++;
//                    dfs(grid,i,j);//利用dfs,以当前位置为起点，对上下左右四个方向进行扩散，扩散的地方都置为0
//                }
//            }
//        }
//
//        return ans;
//    }
//
//    dfs
//    private void dfs(char[][] grid, int row, int clo) {
//        //如果达到边界条件，或者当前位置为0，则直接返回
//        if(row < 0 || row == grid.length || clo < 0 || clo == grid[0].length || grid[row][clo] == '0') return;
//
//        grid[row][clo] = '0';//访问过的地方置为0
//
//        dfs(grid, row + 1, clo);
//        dfs(grid, row - 1, clo);
//        dfs(grid, row, clo - 1);
//        dfs(grid, row, clo + 1);
//    }

    //bfs
    public int numIslands(char[][] grid) {
        int row = grid.length;//行数
        int clo = grid[0].length;//列数
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if(grid[i][j] == '1'){//如果为1，则证明有岛屿，
                    ans++;
                   grid[i][j] = '0';
                   queue.offer(i*clo + j);//存放的是此坐标在整个grid中的位置
                   while (!queue.isEmpty()){
                       int id = queue.remove();
                       int newClo = id % clo;//计算列
                       int newRow = id / clo;//计算行
                       if( newRow + 1 < row && grid[newRow + 1][newClo] == '1'){
                           grid[newRow + 1][newClo] = '0';
                           queue.offer((newRow + 1) * clo + newClo);
                       }
                       if( newRow - 1 >= 0 && grid[newRow - 1][newClo] == '1'){
                           grid[newRow - 1][newClo] = '0';
                           queue.offer((newRow - 1) * clo + newClo);
                       }
                       if( newClo - 1 >= 0 && grid[newRow][newClo - 1] == '1'){
                           grid[newRow][newClo - 1] = '0';
                           queue.offer(newRow * clo + newClo - 1);
                       }
                       if( newClo + 1 < clo && grid[newRow][newClo + 1] == '1'){
                           grid[newRow][newClo + 1] = '0';
                           queue.offer(newRow * clo + newClo + 1);
                       }
                   }
                }
            }
        }

        return ans;
    }


}
