

//给你一个 n x n 整数矩阵 arr ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 82 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;

/**
 * 1289.下降路径最小和  II.minimum-falling-path-sum-ii
 *
 * @author db117
 * @since 2022-12-26 14:04:45
 **/

public class Solution_1289 {
    public static void main(String[] args) {
        Solution solution = new Solution_1289().new Solution();
        // [[1,2,3],[4,5,6],[7,8,9]]
        System.out.println(solution.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int ans = Integer.MAX_VALUE;
            int m = grid.length;
            int n = grid[0].length;
            int[][] f = new int[m][n];
            // 初始化
            System.arraycopy(grid[0], 0, f[0], 0, n);
            for (int i = 1; i < m; i++) {
                Arrays.fill(f[i], Integer.MAX_VALUE);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 取上面非本列最小的
                    for (int k = 0; k < n; k++) {
                        if (k == j) {
                            continue;
                        }
                        f[i][j] = Math.min(f[i][j], grid[i][j] + f[i - 1][k]);
                    }
                }
            }
            // 最后一行最小值
            for (int i : f[m - 1]) {
                ans = Math.min(ans, i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}