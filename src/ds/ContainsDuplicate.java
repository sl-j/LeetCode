package ds;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }

            return false;
    }
}
