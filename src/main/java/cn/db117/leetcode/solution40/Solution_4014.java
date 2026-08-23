

//给你两个整数数组 prices 和 discounts。 
//
// prices[i] 表示第 iᵗʰ 件商品的价格，discounts[j] 表示一个折扣百分比。 
//
// 你可以按照以下规则使用折扣： 
//
// 
// 每个折扣 最多 只能用于一件商品。 
// 每件商品 最多 只能使用一个折扣。 
// 商品也可以不使用任何折扣。 
// 
//
// 如果将 d% 的折扣应用于价格为 p 的商品，则其最终价格为 (p * (100 - d)) / 100。最终价格 不进行四舍五入 。 
//
// 请以最优方式分配折扣，并返回所有商品最终价格之和的 最小值 。与实际答案的误差在 10⁻⁵ 以内的结果都将被接受。 
//
// 
//
// 示例 1： 
//
// 
// 输入： prices = [10,30,21], discounts = [50,60] 
// 
//
// 输出： 32.50000 
//
// 解释： 
//
// 
// 将 discounts[1] = 60 应用于 prices[1] = 30，则最终价格为 30 * (100 - 60) / 100 = 12。 
// 将 discounts[0] = 50 应用于 prices[2] = 21，则最终价格为 21 * (100 - 50) / 100 = 10.5。 
// prices[0] = 10 不使用折扣，因此价格仍为 10。 
// 
//
// 总价为 12 + 10.5 + 10 = 32.50000，这是可能得到的最小值。 
//
//
// 示例 2： 
//
// 
// 输入： prices = [100,70], discounts = [10,40,50] 
// 
//
// 输出： 92.00000 
//
// 解释： 
//
// 
// 将 discounts[2] = 50 应用于 prices[0] = 100，则最终价格为 100 * (100 - 50) / 100 = 50。 
// 将 discounts[1] = 40 应用于 prices[1] = 70，则最终价格为 70 * (100 - 40) / 100 = 42。 
// 
//
// 总价为 50 + 42 = 92.00000，这是可能得到的最小值。 
//
//
// 示例 3： 
//
// 
// 输入： prices = [7,3,9], discounts = [100,100] 
// 
//
// 输出： 3.00000 
//
// 解释： 
//
// 
// 将 discounts[0] = 100 应用于 prices[2] = 9，则最终价格为 9 * (100 - 100) / 100 = 0。 
// 将 discounts[1] = 100 应用于 prices[0] = 7，则最终价格为 7 * (100 - 100) / 100 = 0。 
// prices[1] = 3 不使用折扣，因此价格仍为 3。 
// 
//
// 总价为 0 + 0 + 3 = 3.00000，这是可能得到的最小值。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length, discounts.length <= 10⁵ 
// 1 <= prices[i] <= 10⁵ 
// 1 <= discounts[j] <= 100 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution40;

import java.util.Arrays;

/**
 * 4014.应用折扣后的最低总价.minimum-total-price-after-applying-discounts
 *
 * @author db117
 * @since 2026-08-23 17:06:20
 **/

public class Solution_4014 {
    public static void main(String[] args) {
        Solution solution = new Solution_4014().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double minPrice(int[] prices, int[] discounts) {
            Arrays.sort(prices);
            Arrays.sort(discounts);
            int n = prices.length;
            int m = discounts.length;
            double ans = 0;
            int j = m - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (j >= 0) {
                    ans += prices[i] * (1 - discounts[j] / 100.0);
                    j--;
                } else
                    ans += prices[i];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}