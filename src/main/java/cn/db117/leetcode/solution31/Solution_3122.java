

//给你一个大小为 m x n 的二维矩形 grid 。每次 操作 中，你可以将 任一 格子的值修改为 任意 非负整数。完成所有操作后，你需要确保每个格子 
//grid[i][j] 的值满足： 
//
// 
// 如果下面相邻格子存在的话，它们的值相等，也就是 grid[i][j] == grid[i + 1][j]（如果存在）。 
// 如果右边相邻格子存在的话，它们的值不相等，也就是 grid[i][j] != grid[i][j + 1]（如果存在）。 
// 
//
// 请你返回需要的 最少 操作数目。 
//
// 
//
// 示例 1： 
//
// 
// 输入：grid = [[1,0,2],[1,0,2]] 
// 
//
// 输出：0 
//
// 解释： 
//
// 
//
// 矩阵中所有格子已经满足要求。 
//
// 示例 2： 
//
// 
// 输入：grid = [[1,1,1],[0,0,0]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
//
// 将矩阵变成 [[1,0,1],[1,0,1]] ，它满足所有要求，需要 3 次操作： 
//
// 
// 将 grid[1][0] 变为 1 。 
// 将 grid[0][1] 变为 0 。 
// 将 grid[1][2] 变为 1 。 
// 
//
// 示例 3： 
//
// 
// 输入：grid = [[1],[2],[3]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
//
// 这个矩阵只有一列，我们可以通过 2 次操作将所有格子里的值变为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 1000 
// 0 <= grid[i][j] <= 9 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 7 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;

/**
 * 3122.使矩阵满足条件的最少操作次数.minimum-number-of-operations-to-satisfy-conditions
 *
 * @author db117
 * @since 2024-04-30 11:26:18
 **/

public class Solution_3122 {
    public static void main(String[] args) {
        Solution solution = new Solution_3122().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m, n;
        int[][] count;// 记录每一列的数字出现次数
        int[][] memo;// 记忆化搜索

        public int minimumOperations(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            count = new int[n][10];
            for (int[] ints : grid) {
                for (int j = 0; j < n; j++) {
                    count[j][ints[j]]++;
                }
            }

            memo = new int[n][11];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            return dfs(0, 10);
        }

        // 当前列为 i,上一列选的值为 j
        private int dfs(int i, int j) {

            if (i == n - 1) {
                // 最后一列
                // 找到出现次数最多的数字
                int max = 0;
                for (int k = 0; k < 10; k++) {
                    if (k == j) {
                        continue;
                    }
                    max = Math.max(max, count[n - 1][k]);
                }
                // 需要修改的次数
                return m - max;
            }

            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            int ans = Integer.MAX_VALUE;

            for (int k = 0; k < 10; k++) {
                if (k == j) {
                    continue;
                }
                // 当前列需要修改的次数
                int cur = m - count[i][k];

                // 下一列
                ans = Math.min(ans, cur + dfs(i + 1, k));
            }


            return memo[i][j] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}