package search;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{},0));
    }
//   //暴力
//    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if(target == matrix[i][j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    /**
     * 从右上角开始查询，如果当前值大于target，则下方所有值大于目标值，需要再左列查询，继续向左移动；当移动的位置小于目标值时，左边的值已经排除，右边的值小于
     * 目标值，则可以判定：若目标值存在，则一定在此列，继续向下查询
     */

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int rows = matrix.length,columns = matrix[0].length;
        int row = 0,column = columns - 1;
        while (row < rows && column > -1){//边界条件
            int now = matrix[row][column];
            if(now == target){
                return true;
            }else if(now > target){//大于目标值，则向左查询
                column -= 1;
            }else {//小于目标值，则向下查询
                row += 1;
            }
        }
        return false;
    }
}
