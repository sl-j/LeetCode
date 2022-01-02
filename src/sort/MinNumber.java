package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 */
public class MinNumber {

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3,30,34,5,9}));
    }

    public static String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1 + o2).compareTo(o2 + o1);
//            }
//        });

        Arrays.sort(str, (o1,o2) ->{
                return (o1 + o2).compareTo(o2 + o1);
            }
        );

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }
}
