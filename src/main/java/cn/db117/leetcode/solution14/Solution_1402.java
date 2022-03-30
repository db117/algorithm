

//一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。 
//
// 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。 
//
// 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。 
//
// 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。 
//
// 
//
// 示例 1： 
//
// 
//输入：satisfaction = [-1,-8,0,5,-9]
//输出：14
//解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。 
//
// 示例 2： 
//
// 
//输入：satisfaction = [4,3,2]
//输出：20
//解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
// 
//
// 示例 3： 
//
// 
//输入：satisfaction = [-1,-4,-5]
//输出：0
//解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
// 
//
// 
//
// 提示： 
//
// 
// n == satisfaction.length 
// 1 <= n <= 500 
// -1000 <= satisfaction[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 93 👎 0


package cn.db117.leetcode.solution14;

import java.util.Arrays;

/**
 * 1402.做菜顺序.reducing-dishes
 *
 * @author db117
 * @since 2022-03-30 15:27:12
 **/

public class Solution_1402 {
    public static void main(String[] args) {
        Solution solution = new Solution_1402().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            int len = satisfaction.length;

            Arrays.sort(satisfaction);
            // 都是负数,不做了
            if (satisfaction[len - 1] <= 0) {
                return 0;
            }

            // 都是正数,挨着做
            if (satisfaction[0] >= 0) {
                int ans = 0;
                for (int i = 0; i < len; i++) {
                    ans += satisfaction[i] * (i + 1);
                }
                return ans;
            }

            // 都是负数
            // 反向做,取最大值
            int ans = 0;
            int sum = 0;// 从后面开始算的和
            int all = 0;// 多次加 sum,可理解为 索引*数字
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                // 当前数字为索引 1,后面的数字都在加一次
                all += sum + satisfaction[i];
                ans = Math.max(ans, all);
                // 从后面加到当前数字和
                sum += satisfaction[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}