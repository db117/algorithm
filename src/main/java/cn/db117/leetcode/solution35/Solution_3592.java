

//给你一个 从 1 开始计数 的整数数组 numWays，其中 numWays[i] 表示使用某些 固定 面值的硬币（每种面值可以使用无限次）凑出总金额 i 
//的方法数。每种面值都是一个 正整数 ，并且其值 最多 为 numWays.length。 
//
// 然而，具体的硬币面值已经 丢失 。你的任务是还原出可能生成这个 numWays 数组的面值集合。 
//
// 返回一个按从小到大顺序排列的数组，其中包含所有可能的 唯一 整数面值。 
//
// 如果不存在这样的集合，返回一个 空 数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： numWays = [0,1,0,2,0,3,0,4,0,5] 
// 
//
// 输出： [2,4,6] 
//
// 解释： 
//
// 
// 
// 
// 金额 
// 方法数 
// 解释 
// 
// 
// 1 
// 0 
// 无法用硬币凑出总金额 1。 
// 
// 
// 2 
// 1 
// 唯一的方法是 [2]。 
// 
// 
// 3 
// 0 
// 无法用硬币凑出总金额 3。 
// 
// 
// 4 
// 2 
// 可以用 [2, 2] 或 [4]。 
// 
// 
// 5 
// 0 
// 无法用硬币凑出总金额 5。 
// 
// 
// 6 
// 3 
// 可以用 [2, 2, 2]、[2, 4] 或 [6]。 
// 
// 
// 7 
// 0 
// 无法用硬币凑出总金额 7。 
// 
// 
// 8 
// 4 
// 可以用 [2, 2, 2, 2]、[2, 2, 4]、[2, 6] 或 [4, 4]。 
// 
// 
// 9 
// 0 
// 无法用硬币凑出总金额 9。 
// 
// 
// 10 
// 5 
// 可以用 [2, 2, 2, 2, 2]、[2, 2, 2, 4]、[2, 4, 4]、[2, 2, 6] 或 [4, 6]。 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入： numWays = [1,2,2,3,4] 
// 
//
// 输出： [1,2,5] 
//
// 解释： 
//
// 
// 
// 
// 金额 
// 方法数 
// 解释 
// 
// 
// 1 
// 1 
// 唯一的方法是 [1]。 
// 
// 
// 2 
// 2 
// 可以用 [1, 1] 或 [2]。 
// 
// 
// 3 
// 2 
// 可以用 [1, 1, 1] 或 [1, 2]。 
// 
// 
// 4 
// 3 
// 可以用 [1, 1, 1, 1]、[1, 1, 2] 或 [2, 2]。 
// 
// 
// 5 
// 4 
// 可以用 [1, 1, 1, 1, 1]、[1, 1, 1, 2]、[1, 2, 2] 或 [5]。 
// 
// 
// 
//
// 示例 3： 
//
// 
// 输入： numWays = [1,2,3,4,15] 
// 
//
// 输出： [] 
//
// 解释： 
//
// 没有任何面值集合可以生成该数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= numWays.length <= 100 
// 0 <= numWays[i] <= 2 * 10⁸ 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution35;

import java.util.ArrayList;
import java.util.List;

/**
 * 3592.硬币面值还原.inverse-coin-change
 *
 * @author db117
 * @since 2025-06-23 15:13:20
 **/

public class Solution_3592 {
    public static void main(String[] args) {
        Solution solution = new Solution_3592().new Solution();
        // [0,1,0,2,0,3,0,4,0,5]
//        System.out.println(solution.findCoins(new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0, 5}));

        // [1,2,3,4,15]
        System.out.println(solution.findCoins(new int[]{1, 2, 3, 4, 15}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findCoins(int[] numWays) {
            List<Integer> ans = new ArrayList<>();
            int n = numWays.length;
            // 前 i 个硬币，j 个金额的构成数量
            long[][] dp = new long[n + 1][n + 1];
            // 初始值
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                // 前 i 个硬币组成固定金额的数量和题目给的差
                long diff = numWays[i - 1] - dp[i - 1][i];
                if (diff == 0) {
                    // 当前数字并没有出现,没有贡献。后面的数据不需要动，直接复制
                    System.arraycopy(dp[i - 1], 0, dp[i], 0, n + 1);
                } else if (diff == 1) {
                    ans.add(i);
                    for (int j = 0; j <= n; j++) {
                        if (j >= i) {
                            // 金额大于等于当前硬币值，可以选，也可以不选当前硬币
                            dp[i][j] = dp[i - 1][j] + dp[i][j - i];
                        } else {
                            // 金额小于当前硬币值
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                } else {
                    // 不合法，不可能构成
                    return List.of();
                }
                ;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}