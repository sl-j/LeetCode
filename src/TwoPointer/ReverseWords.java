package TwoPointer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords(new String("a good   example")));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] reverseString= s.trim().split(" ");
        for (int i = reverseString.length - 1; i > -1 ; i--) {
            if(!reverseString[i].equals("")) sb.append(reverseString[i] + " ");
        }
        return sb.toString().trim();

    }
}
