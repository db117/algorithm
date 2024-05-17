

//给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 
//c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。 
//
// 你可以从 任一 单元格开始，并且必须至少移动一次。 
//
// 返回你能得到的 最大 总得分。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]] 
// 
//
// 输出：9 
//
// 解释：从单元格 (0, 1) 开始，并执行以下移动： - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。 - 从单元格 (2
//, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。 总得分为 2 + 7 = 9 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：grid = [[4,3,2],[3,2,1]] 
// 
//
// 输出：-1 
//
// 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 5 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;
import java.util.List;

/**
 * 3148.矩阵中的最大得分.maximum-difference-score-in-a-grid
 *
 * @author db117
 * @since 2024-05-17 10:09:11
 **/

public class Solution_3148 {
    public static void main(String[] args) {
        Solution solution = new Solution_3148().new Solution();
        // [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
        System.out.println(solution.maxScore(Arrays.asList(
                Arrays.asList(9, 5, 7, 3),
                Arrays.asList(8, 9, 6, 1),
                Arrays.asList(6, 7, 14, 3),
                Arrays.asList(2, 5, 3, 1)
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(List<List<Integer>> grid) {
            // 相当于找到左上边的最小值
            int m = grid.size();
            int n = grid.get(0).size();
            int[][] dp = new int[m + 1][n + 1];
            // 初始化
            Arrays.fill(dp[0], Integer.MAX_VALUE);
            for (int i = 0; i < m; i++) {
                dp[i + 1][0] = Integer.MAX_VALUE;
            }
            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Integer curNum = grid.get(i).get(j);
                    // 左上边的最小值
                    int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    // 最大的差值
                    ans = Math.max(ans, curNum - min);
                    // 计算从左上角到当前位置的最小值
                    dp[i + 1][j + 1] = Math.min(min, curNum);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}