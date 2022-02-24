package SString;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String s = reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(s);
    }

    public static String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                swap(chars, left, right);
                left++;
                right--;
            } else if (!Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                left++;
            } else if (Character.isLetter(chars[left]) && !Character.isLetter(chars[right])) {
                right--;
            }else {
                left++;
                right--;
            }
        }
       return new String(chars);
    }
    public static void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
