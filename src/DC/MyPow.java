package DC;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {

    public static void main(String[] args) {
        double v = myPow(2, 11);
        System.out.println(v);

    }

    public  static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(n < 0){
            x = 1/x;
            b = -b;
        }
        while (b>0){
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
