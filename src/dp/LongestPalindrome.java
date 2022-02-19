package dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    static String longestPalindrome(String s){
        if(s.length() < 2){
            return s;
        }

        int maxLen = 1;//记录最长回文串的长度（要记录为1，在没有回文串的情况下，保证最少输出一个字符，否则会通不过有些样例）
        int begin = 0;//记录最长回文串的开始位置

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                    if(j - i + 1 > maxLen && valid(s,i,j)){
                        maxLen = j - i +1;
                        begin = i;
                    }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    /**
     * 验证是否是回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    static boolean valid(String s,int left,int right){
        while (left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
