package mn;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    @Test
    public void test(){
        spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    /**
     * 每遍历一行或一列，就抛去这一行或一列，移动边界
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int clo = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int top = 0;//上边界
        int left = 0;//左边界
        int right = clo - 1;//右边界
        int bottom = row - 1;//左边界
        int num = 0;
        int sum = row * clo;

        while (num < sum){
            //左到右,列变行不变
            for (int i = left; i <= right && num < sum; i++) {
                ans.add(matrix[top][i]);
                num++;
            }
            top++;//顶行遍历完成，下移

            //从上到下,行变列不变
            for (int i = top; i <= bottom && num < sum; i++) {
                ans.add(matrix[i][right]);
                num++;
            }
            right--;//最右列遍历完成，左移

            //从右到左，列变行不变
            for (int i = right; i >= left && num < sum; i--) {
                ans.add(matrix[bottom][i]);
                num++;
            }
            bottom--;//最低行遍历完成，上移

            //从下到上，行变列不变
            for (int i = bottom; i >= top && num < sum; i--) {
                ans.add(matrix[i][left]);
                num++;
            }
            left++;//最左行遍历完成,右移
        }

        return ans;
    }
}
