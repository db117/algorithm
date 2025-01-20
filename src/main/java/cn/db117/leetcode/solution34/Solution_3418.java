

//给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右
//或向下移动。 
//
// 网格中的每个单元格包含一个值 coins[i][j]： 
//
// 
// 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。 
// 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。 
// 
//
// 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。 
//
// 注意：机器人的总金币数可以是负数。 
//
// 返回机器人在路径上可以获得的 最大金币数 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： coins = [[0,1,-1],[1,-2,3],[2,-3,4]] 
// 
//
// 输出： 8 
//
// 解释： 
//
// 一个获得最多金币的最优路径如下： 
//
// 
// 从 (0, 0) 出发，初始金币为 0（总金币 = 0）。 
// 移动到 (0, 1)，获得 1 枚金币（总金币 = 0 + 1 = 1）。 
// 移动到 (1, 1)，遇到强盗抢走 2 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = 1）。 
// 移动到 (1, 2)，获得 3 枚金币（总金币 = 1 + 3 = 4）。 
// 移动到 (2, 2)，获得 4 枚金币（总金币 = 4 + 4 = 8）。 
// 
//
// 示例 2： 
//
// 
// 输入： coins = [[10,10,10],[10,10,10]] 
// 
//
// 输出： 40 
//
// 解释： 
//
// 一个获得最多金币的最优路径如下： 
//
// 
// 从 (0, 0) 出发，初始金币为 10（总金币 = 10）。 
// 移动到 (0, 1)，获得 10 枚金币（总金币 = 10 + 10 = 20）。 
// 移动到 (0, 2)，再获得 10 枚金币（总金币 = 20 + 10 = 30）。 
// 移动到 (1, 2)，获得 10 枚金币（总金币 = 30 + 10 = 40）。 
// 
//
// 
//
// 提示： 
//
// 
// m == coins.length 
// n == coins[i].length 
// 1 <= m, n <= 500 
// -1000 <= coins[i][j] <= 1000 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 3 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3418.机器人可以获得的最大金币数.maximum-amount-of-money-robot-can-earn
 *
 * @author db117
 * @since 2025-01-20 16:49:04
 **/

public class Solution_3418 {
    public static void main(String[] args) {
        Solution solution = new Solution_3418().new Solution();

        // [[-7,12,12,13],[-6,19,19,-6],[9,-2,-10,16],[-4,14,-10,-9]]
        System.out.println(solution.maximumAmount(new int[][]{
                {-7, 12, 12, 13},
                {-6, 19, 19, -6},
                {9, -2, -10, 16},
                {-4, 14, -10, -9}
        }));// 60
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] coins;
        int[][][] memo;
        int m, n;

        public int maximumAmount(int[][] coins) {
            this.coins = coins;
            this.m = coins.length;
            this.n = coins[0].length;
            memo = new int[m][n][3];
            for (int[][] ints : memo) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, Integer.MIN_VALUE);
                }
            }
            return dfs(m - 1, n - 1, 2);
        }

        private int dfs(int i, int j, int k) {
            if (i < 0 || j < 0) {
                return Integer.MIN_VALUE / 2;
            }
            int cur = coins[i][j];
            if (i == 0 && j == 0) {
                // 到位置了
                if (k > 0) {
                    // 还可以继续感化
                    return Math.max(0, cur);
                }
                return cur;
            }


            if (memo[i][j][k] != Integer.MIN_VALUE) {
                return memo[i][j][k];
            }
            // 不感化
            int ans = Math.max(dfs(i - 1, j, k), dfs(i, j - 1, k)) + cur;


            // 感化
            if (cur < 0 && k > 0) {
                ans = Math.max(ans, dfs(i - 1, j, k - 1));
                ans = Math.max(ans, dfs(i, j - 1, k - 1));

            }

            return memo[i][j][k] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}