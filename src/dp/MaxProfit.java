package dp;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
//简单的动态规划题目，找出最小的值，然后和后续的值进行计算，得到最大值
    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = prices[0],res = 0;
        for (int i = 0; i < prices.length; i++) {
             min = Math.min(min,prices[i]);//找出最小值
             res = Math.max(res,prices[i] - min);//和新的最小值计算
        }
        return res;

    }

}
