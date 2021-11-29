package Window;

import java.util.Arrays;

public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion(new String("abc"),new String("bbbca")));
    }

    //比较ascii码，在ascii相同的情况下，比较字符出现次数是否一样(时间复杂度有点高)
//    public static boolean checkInclusion(String s1, String s2) {
//        int n = s1.length(),sum1 = 0,sum2 = 0,j;
//        int[] countS1 = new int[26];
//        Boolean flag = false;
//        for (int i = 0; i < n; i++) {
//            sum1 += s1.charAt(i);
//            countS1[s1.charAt(i)-'a']++;
//        }
//        for(int i = 0;i<s2.length();i++){
//            sum2 = 0;
//            for(j = i;j < i+n;j++){
//                if(j==s2.length()){
//                    break;
//                }
//                sum2 += s2.charAt(j);
//            }
//            if(sum1 == sum2){
//                int[] count = new int[26];
//                for(int left = i;left < j; left++){
//                    count[s2.charAt(left)-'a']++;
//                }
//                if(Arrays.equals(count,countS1)){
//                    return true;
//                }else {
//                    flag = false;
//                }
//            }
//        }
//        return flag;
//    }
    //滑动窗口的思想（窗口内字符出现的次数和s1相等，并且长度相同，可判断为子串）
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){
            return false;
        }
        int[] countS1 = new int[26];//记录s1每个字符出现的次数
        int[] countS2 = new int[26];
        for (int i = 0; i < n1; i++) {
            countS1[s1.charAt(i)-'a']++;//计算s1每个字符出现的次数
            countS2[s2.charAt(i)-'a']++;//计算滑动窗口内每个字符出现的次数，滑动窗口大小为n1
        }
        if(Arrays.equals(countS1,countS2)){
            return true;
        }
        for (int i = n1; i < n2; i++) {//n1之前的已经统计
            countS2[s2.charAt(i)-'a']++;//新加入窗口的字符，进行次数统计
            countS2[s2.charAt(i-n1)-'a']--;//滑出窗口的字符，字符次数减1
            if(Arrays.equals(countS1,countS2)){
                return true;
            }
        }
        return false;
    }
}
