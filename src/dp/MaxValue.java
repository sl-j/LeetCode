package dp;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValue {
    public static void main(String[] args) {

    }

    /**
     * 动态规划题目，右下角的数值来自左边或上边的最大值和自身的和，对于第一行和第一列需要额外判断，因此可以额外附加
     *一行一列，使用通用的状态转移方程
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows + 1][columns + 1];//多开一行一列，可以不需要判断边界条件
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {//多的第0行和第0列，全为1
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];//dp比grid的矩阵多一行一列
            }
        }
        return dp[rows][columns];
    }
}
