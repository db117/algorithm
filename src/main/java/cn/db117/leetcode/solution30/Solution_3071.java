

//给你一个下标从 0 开始、大小为 n x n 的矩阵 grid ，其中 n 为奇数，且 grid[r][c] 的值为 0 、1 或 2 。 
//
// 如果一个单元格属于以下三条线中的任一一条，我们就认为它是字母 Y 的一部分： 
//
// 
// 从左上角单元格开始到矩阵中心单元格结束的对角线。 
// 从右上角单元格开始到矩阵中心单元格结束的对角线。 
// 从中心单元格开始到矩阵底部边界结束的垂直线。 
// 
//
// 当且仅当满足以下全部条件时，可以判定矩阵上写有字母 Y ： 
//
// 
// 属于 Y 的所有单元格的值相等。 
// 不属于 Y 的所有单元格的值相等。 
// 属于 Y 的单元格的值与不属于Y的单元格的值不同。 
// 
//
// 每次操作你可以将任意单元格的值改变为 0 、1 或 2 。返回在矩阵上写出字母 Y 所需的 最少 操作次数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,2,2],[1,1,0],[0,1,0]]
//输出：3
//解释：将在矩阵上写出字母 Y 需要执行的操作用蓝色高亮显示。操作后，所有属于 Y 的单元格（加粗显示）的值都为 1 ，而不属于 Y 的单元格的值都为 0 。
//
//可以证明，写出 Y 至少需要进行 3 次操作。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]
//输出：12
//解释：将在矩阵上写出字母 Y 需要执行的操作用蓝色高亮显示。操作后，所有属于 Y 的单元格（加粗显示）的值都为 0 ，而不属于 Y 的单元格的值都为 2 。
//
//可以证明，写出 Y 至少需要进行 12 次操作。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 49 
// n == grid.length == grid[i].length 
// 0 <= grid[i][j] <= 2 
// n 为奇数。 
// 
//
// Related Topics 数组 哈希表 计数 矩阵 👍 2 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3071.在矩阵上写出字母 Y 所需的最少操作次数.minimum-operations-to-write-the-letter-y-on-a-grid
 *
 * @author db117
 * @since 2024-03-07 11:08:12
 **/

public class Solution_3071 {
    public static void main(String[] args) {
        Solution solution = new Solution_3071().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] yPath;

        public int minimumOperationsToWriteY(int[][] grid) {
            int ans = Integer.MAX_VALUE;
            mark(grid);
            // 一个个猜
            ans = Math.min(ans, check(grid, 0, 1));
            ans = Math.min(ans, check(grid, 0, 2));
            ans = Math.min(ans, check(grid, 1, 0));
            ans = Math.min(ans, check(grid, 1, 2));
            ans = Math.min(ans, check(grid, 2, 1));
            ans = Math.min(ans, check(grid, 2, 0));

            return ans;
        }

        private void mark(int[][] grid) {
            int n = grid.length;
            yPath = new boolean[n][n];
            // y 上的数字
            for (int i = 0; i < n / 2; i++) {
                yPath[i][i] = true;
                yPath[i][n - 1 - i] = true;
            }
            for (int i = n / 2; i < n; i++) {
                yPath[i][n / 2] = true;
            }
        }

        private int check(int[][] grid, int x, int y) {
            int n = grid.length;
            int ans = 0;
            // y 上的数字
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!yPath[i][j]) {
                        // 不在 y 上
                        if (grid[i][j] != x) {
                            ans++;
                        }
                    } else {
                        if (grid[i][j] != y) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}