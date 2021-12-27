package dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;dp[1] = 1;//数字为空或者一位数字的情况下，翻译结果都为1;
        for (int i = 2; i < dp.length; i++) {
            int n = (s.charAt(i - 2) - '0')*10 + (s.charAt(i - 1) - '0');//翻译结果依赖于前两个数字
            if(n >= 10 && n <= 25){
                dp[i] = dp[i-1] + dp[i-2];//两个数字可以组合时，当前的组合结果依赖于前两位的组合结果
            }else {
                dp[i] = dp[i-1];//不能组合时，组合结果不变当前组合结果和前一个数字的组合结果相同
            }
        }
        return dp[s.length()];
    }
}
