

//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 137 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1139.最大的以 1 为边界的正方形.largest-1-bordered-square
 *
 * @author db117
 * @since 2023-02-17 10:23:45
 **/

public class Solution_1139 {
    public static void main(String[] args) {
        Solution solution = new Solution_1139().new Solution();
        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            // 前缀和
            int[][] sumUp = new int[n + 1][m + 1];
            int[][] sumLeft = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 左边前缀和
                    sumLeft[i][j + 1] = sumLeft[i][j] + grid[i][j];
                    // 上边
                    sumUp[i + 1][j] = sumUp[i][j] + grid[i][j];
                }
            }
            // 枚举边长,从大到小开始 碰见合适的直接返回
            for (int k = Math.min(m, n); k > 0; k--) {
                // 枚举左上角
                for (int i = 0; i <= n - k; i++) {
                    for (int j = 0; j <= m - k; j++) {
                        // 校验上边
                        if (sumLeft[i][j + k] - sumLeft[i][j] != k) {
                            continue;
                        }
                        // 校验下边
                        if (sumLeft[i + k - 1][j + k] - sumLeft[i + k - 1][j] != k) {
                            continue;
                        }
                        // 校验左边
                        if (sumUp[i + k][j] - sumUp[i][j] != k) {
                            continue;
                        }
                        // 校验右边
                        if (sumUp[i + k][j + k - 1] - sumUp[i][j + k - 1] != k) {
                            continue;
                        }

                        return k * k;
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}