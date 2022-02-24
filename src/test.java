import java.util.*;

public class test {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbd"));
    }

    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if( j - i + 1 > maxLen && valid(s,i,j)){
                    maxLen = j - i +1;
                    start = i;
                }
            }
        }
        return s.substring(start,start + maxLen);
    }

    public static Boolean valid(String s, int start,int end){
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

}
