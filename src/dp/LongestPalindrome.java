package dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

//    static String longestPalindrome(String s){
//        if(s.length() < 2){
//            return s;
//        }
//
//        int maxLen = 1;//记录最长回文串的长度（要记录为1，在没有回文串的情况下，保证最少输出一个字符，否则会通不过有些样例）
//        int begin = 0;//记录最长回文串的开始位置
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                    if(j - i + 1 > maxLen && valid(s,i,j)){
//                        maxLen = j - i +1;
//                        begin = i;
//                    }
//            }
//        }
//        return s.substring(begin,begin + maxLen);
//    }
//
//    /**
//     * 验证是否是回文串
//     * @param s
//     * @param left
//     * @param right
//     * @return
//     */
//    static boolean valid(String s,int left,int right){
//        while (left < right){
//            if(s.charAt(left++) != s.charAt(right--)){
//                return false;
//            }
//        }
//        return true;
//    }

//    /**
//     * 中心扩展的方法，以每一个字符为中心，向两边扩展，寻找最长的回文子串
//     * @param s
//     * @return
//     */
//    static String longestPalindrome(String s) {
//        if (s.length() < 2) {
//            return s;
//        }
//
//        int maxLen = 0;//记录最长回文串的长度
//        int begin = 0;//记录最长回文串的开始位置
//
//        for (int i = 0; i < s.length() - 1; i++) {//向右最多扩展到len-1的地方
//            //可能情况，一个是aba，一个是abba
//            int oLen = expandAroundCenter(s,i,i);
//            int jLen = expandAroundCenter(s,i,i+1);
//
//            int currentLen = Math.max(oLen,jLen);//记录比较后的最大值
//
//            if(maxLen < currentLen){
//                maxLen = currentLen;
//                begin = i - (maxLen - 1)/2;
//            }
//        }
//
//        return s.substring(begin,begin + maxLen);
//
//    }
//
//    static int expandAroundCenter(String s,int left,int right){
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }

    /**
     * 动态规划解法:dp[i][j]表示从i到j是否为回文字符串
     *        字符串的i-j是不是回文串取决于i+1~j-1是不是回文串，可以有s[i] == s[j] && dp[i+1][j-1]
     * @param s
     * @return
     */
    static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int maxLen = 1;//记录最长回文串的长度
        int begin = 0;//记录最长回文串的开始位置

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
                if(i == i) dp[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j ; i++) {
                if(s.charAt(i) != s.charAt(j)){//不等于时，置为false
                    dp[i][j] = false;
                }else {
                    //头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if(j - i + 1 <= 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                if(dp[i][j] && j - i + 1 >maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }

        }
        return s.substring(begin,begin + maxLen);

    }

}
