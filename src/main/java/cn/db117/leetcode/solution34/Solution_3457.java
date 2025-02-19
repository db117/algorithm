

//给你一个长度为 n 的整数数组 pizzas，其中 pizzas[i] 表示第 i 个披萨的重量。每天你会吃 恰好 4 个披萨。由于你的新陈代谢能力惊人，当
//你吃重量为 W、X、Y 和 Z 的披萨（其中 W <= X <= Y <= Z）时，你只会增加 1 个披萨的重量！体重增加规则如下： 
//
// 
// 在 奇数天（按 1 开始计数）你会增加 Z 的重量。 
// 在 偶数天，你会增加 Y 的重量。 
// 
//
// 请你设计吃掉 所有 披萨的最优方案，并计算你可以增加的 最大 总重量。 
//
// 注意：保证 n 是 4 的倍数，并且每个披萨只吃一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入： pizzas = [1,2,3,4,5,6,7,8] 
// 
//
// 输出： 14 
//
// 解释： 
//
// 
// 第 1 天，你吃掉下标为 [1, 2, 4, 7] = [2, 3, 5, 8] 的披萨。你增加的重量为 8。 
// 第 2 天，你吃掉下标为 [0, 3, 5, 6] = [1, 4, 6, 7] 的披萨。你增加的重量为 6。 
// 
//
// 吃掉所有披萨后，你增加的总重量为 8 + 6 = 14。 
//
// 示例 2： 
//
// 
// 输入： pizzas = [2,1,1,1,1,1,1,1] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
// 第 1 天，你吃掉下标为 [4, 5, 6, 0] = [1, 1, 1, 2] 的披萨。你增加的重量为 2。 
// 第 2 天，你吃掉下标为 [1, 2, 3, 7] = [1, 1, 1, 1] 的披萨。你增加的重量为 1。 
// 
//
// 吃掉所有披萨后，你增加的总重量为 2 + 1 = 3。 
//
// 
//
// 提示： 
//
// 
// 4 <= n == pizzas.length <= 2 * 10⁵ 
// n 是 4 的倍数。 
// 
//
// Related Topics 贪心 数组 排序 👍 3 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3457.吃披萨.eat-pizzas
 *
 * @author db117
 * @since 2025-02-19 11:13:05
 **/

public class Solution_3457 {
    public static void main(String[] args) {
        Solution solution = new Solution_3457().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxWeight(int[] pizzas) {
            long ans = 0;
            Arrays.sort(pizzas);
            int n = pizzas.length;
            int all = pizzas.length / 4;

            // 偶数天
            int even = all / 2;
            // 奇数天
            int odd = all - even;

            for (int i = n - 1; i >= 0; i--) {
                if (odd > 0) {
                    // 先吃奇数天的
                    ans += pizzas[i];
                    odd--;
                } else if (even > 0) {
                    // 奇数天的吃完了，在吃偶数天的
                    i--;
                    ans += pizzas[i];
                    even--;
                } else {
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}