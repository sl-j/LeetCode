package SString;

import org.junit.Test;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Convert {

    @Test
    public void test(){
        convert("PAYPALISHIRING",3);
    }

    public String convert(String s, int numRows) {
        StringBuilder[] tmp = new StringBuilder[numRows];
        for(int i = 0;i < numRows ;i++) tmp[i] = new StringBuilder();

        int row = 0;
        int flag = -1;

        for(char c: s.toCharArray()){
            tmp[row].append(c);
            if(row == 0 || row == numRows - 1) flag = -flag;
            row += flag;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb : tmp){ ans.append(sb);}

        return ans.toString();
    }
}
