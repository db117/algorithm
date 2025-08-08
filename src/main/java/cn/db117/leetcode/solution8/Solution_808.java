

//你有两种汤，A 和 B，每种初始为 n 毫升。在每一轮中，会随机选择以下四种服务操作中的一种，每种操作的概率为 0.25，且与之前的所有轮次 无关： 
//
// 
// 从汤 A 取 100 毫升，从汤 B 取 0 毫升 
// 从汤 A 取 75 毫升，从汤 B 取 25 毫升 
// 从汤 A 取 50 毫升，从汤 B 取 50 毫升 
// 从汤 A 取 25 毫升，从汤 B 取 75 毫升 
// 
//
// 注意： 
//
// 
// 不存在先分配 100 ml 汤B 的操作。 
// 汤 A 和 B 在每次操作中同时被倒入。 
// 如果一次操作要求你倒出比剩余的汤更多的量，请倒出该汤剩余的所有部分。 
// 
//
// 操作过程在任何回合中任一汤被用完后立即停止。 
//
// 返回汤 A 在 B 前耗尽的概率，加上两种汤在 同一回合 耗尽概率的一半。返回值在正确答案 10⁻⁵ 的范围内将被认为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 50
//输出：0.62500
//解释：
//如果我们选择前两个操作，A 首先将变为空。
//对于第三个操作，A 和 B 会同时变为空。
//对于第四个操作，B 首先将变为空。
//所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
// 
//
// 示例 2: 
//
// 
//输入：n = 100
//输出：0.71875
//解释：
//如果我们选择第一个操作，A 首先将变为空。
//如果我们选择第二个操作，A 将在执行操作 [1, 2, 3] 时变为空，然后 A 和 B 在执行操作 4 时同时变空。
//如果我们选择第三个操作，A 将在执行操作 [1, 2] 时变为空，然后 A 和 B 在执行操作 3 时同时变空。
//如果我们选择第四个操作，A 将在执行操作 1 时变为空，然后 A 和 B 在执行操作 2 时同时变空。
//所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.71875。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 数学 动态规划 概率与统计 👍 274 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;

/**
 * 808.分汤.soup-servings
 *
 * @author db117
 * @since 2025-08-08 19:35:55
 **/

public class Solution_808 {
    public static void main(String[] args) {
        Solution solution = new Solution_808().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        double[][] memo;

        public double soupServings(int n) {
            // n 越大，a 的概率越大，那么到某个阈值的时候就不需要计算了 10⁻⁵
            if (n > 5000) {
                // 概率过小
                return 1;
            }

            // 中间的数字不需要用到
            n = (n + 24) / 25;
            memo = new double[n + 1][n + 1];
            for (double[] doubles : memo) {
                Arrays.fill(doubles, -1);
            }

            return dfs(n, n);
        }

        double dfs(int a, int b) {
            if (a <= 0 && b <= 0) {
                // 同时耗尽
                return 0.5;
            }
            if (a <= 0) {
                // A 耗尽
                return 1;
            }
            if (b <= 0) {
                // B 耗尽
                return 0;
            }

            if (memo[a][b] != -1) {
                return memo[a][b];
            }

            // 4 种可能性一样的，都试试看
            return memo[a][b] =
                    (dfs(a - 4, b)
                            + dfs(a - 3, b - 1)
                            + dfs(a - 2, b - 2)
                            + dfs(a - 1, b - 3)) / 4;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}