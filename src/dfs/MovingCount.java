package dfs;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
//        System.out.println(add(35,38));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,0,0,m ,n,k);
    }

    public static int dfs(boolean[][] visited,int i,int j,int m,int n,int k){
        if(i == m ||j == n || add(i) + add(j) > k || visited[i][j]) return 0;//如过不满足条件，则直接返回0,且不能向下和向右走
        visited[i][j] = true;
        return dfs(visited,i + 1,j,m,n,k) + dfs(visited,i,j + 1,m,n,k) + 1;//如满足条件，从（0，0）开始扩展，直接向下向右，可以走满整个矩阵

    }
    public static int add(int m){
        int sum = 0;
        while (m > 0){
            sum += m%10;
            m /=10;
        }
        return sum;
    }
}
