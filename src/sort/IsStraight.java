package sort;

import java.util.HashSet;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsStraight {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0,0,6,2,5}));
    }

    public static boolean isStraight(int[] nums) {
        int min = 14,max = 0;
        HashSet<Integer> set = new HashSet<>();//set去重
        for (int num: nums) {
            if(num == 0) continue;//去除大小王
            if(!set.add(num)) return false;//有重复牌则直接返回false
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        if(max - min < 5) return true;//比较最大值和最小值
        else return false;
    }
}
