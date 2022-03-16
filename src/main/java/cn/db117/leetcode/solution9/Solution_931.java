

//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 153 👎 0


package cn.db117.leetcode.solution9;

/**
 * 931.下降路径最小和.minimum-falling-path-sum
 *
 * @author db117
 * @since 2022-03-16 14:30:22
 **/

public class Solution_931 {
    public static void main(String[] args) {
        Solution solution = new Solution_931().new Solution();
        // [[17,82],[1,-44]]
        System.out.println(solution.minFallingPathSum(new int[][]{{17, 82}, {1, -44}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            // 标准动态规划
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            // 初始化
            System.arraycopy(matrix[0], 0, dp[0], 0, n);

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;

                    // 只能从三个格子过来
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                    }
                    if (j + 1 < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);

                }
            }

            // 最后一列的最小值
            int ans = Integer.MAX_VALUE;
            for (int i : dp[n - 1]) {
                ans = Math.min(i, ans);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}