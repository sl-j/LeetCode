package dfs;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0,1,0},{0,2,1}};
        floodFill(image,1,1,2);
        System.out.println();
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor){
            dfs(image,sr,sc,newColor,oldColor);
        }

        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int newColor,int oldColor){
        //结束条件：行或列达到边界；当前区域的颜色等于新颜色
        if (sr<0||sr==image.length||sc<0||sc== image[0].length||image[sr][sc]!=oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image,sr+1,sc,newColor,oldColor);
        dfs(image,sr-1,sc,newColor,oldColor);
        dfs(image,sr,sc+1,newColor,oldColor);
        dfs(image,sr,sc-1,newColor,oldColor);
        }

}


