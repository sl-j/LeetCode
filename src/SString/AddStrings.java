package SString;

import org.junit.Test;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {

    @Test
    public void test(){
        addStrings("11","123");
    }

    public String addStrings(String num1, String num2) {
        int flag = 0;
        StringBuilder ans = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        while (len1 >=0 || len2 >=0){
            int n1 = len1 < 0 ? 0 : num1.charAt(len1--) - '0';
            int n2 = len2 < 0 ? 0 : num2.charAt(len2--) - '0';
            int sum = flag + n1 + n2;
            flag = sum > 9 ? 1 : 0;
            ans.append(sum % 10);
        }
        if(flag == 1) ans.append(flag);
        return ans.reverse().toString();
    }
}
