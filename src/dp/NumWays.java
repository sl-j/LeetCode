package dp;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumWays {
    static final int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

//    public static int numWays(int n) {
//        if(n == 0 || n == 1) return 1;
//        int[] dp = new int[n+5];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n ; i++) {
//            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
//        }
//        return dp[n];
//    }
    public static int numWays(int n){
        if(n<2) return n;
        long[][] p ={{1,1},{1,0}};//初始化连乘的工具矩阵,矩阵都要定义为long，不然会下溢
        int f0 = 0,f1 = 1;
        long[][] a = {{f1},{f0}};//定义f1和f2的初值矩阵
        long[][] res = pow(p,n-1);
        res = metrixMul(res,a);
        return (int)(res[0][0] + res[1][0]%mod);

}
    public static long[][] pow(long[][] p ,long n){
        long[][] res = {{1,0},{0,1}};//单位矩阵
        while (n > 0){
            if((n & 1) == 1){//按位取，判断每位是否为1
                res = metrixMul(res,p);//只有为1时，才计算，p在每回合都会计算
            }
            n>>=1;
            p = metrixMul(p,p);//n没移动一位，做一次平方
        }
        return res;
    }
    //矩阵乘法
    public static long[][] metrixMul(long[][] a,long[][] b){
        long[][] res = new long[2][2];
        for (int i = 0; i < a.length; i++) {//行
            for (int j = 0; j < b[0].length; j++) {//列
                for (int k = 0; k < b.length; k++) {//a的列等于b的行
                    res[i][j] += a[i][k]*b[k][j];
                    res[i][j]%=mod;
                }
            }
        }
        return res;
    }
}
