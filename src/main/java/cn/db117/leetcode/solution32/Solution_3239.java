

//给你一个 m x n 的二进制矩阵 grid 。 
//
// 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。 
//
// 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。 
//
// 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：grid = [[1,0,0],[0,0,0],[0,0,1]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
//
// 将高亮的格子翻转，得到所有行都是回文的。 
//
// 示例 2： 
//
// 
// 输入：grid = [[0,1],[0,1],[0,0]] 
// 
//
// 输出：1 
//
// 解释： 
//
// 
//
// 将高亮的格子翻转，得到所有列都是回文的。 
//
// 示例 3： 
//
// 
// 输入：grid = [[1],[0]] 
// 
//
// 输出：0 
//
// 解释： 
//
// 所有行已经是回文的。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m * n <= 2 * 10⁵ 
// 0 <= grid[i][j] <= 1 
// 
//
// Related Topics 数组 双指针 矩阵 👍 25 👎 0


package cn.db117.leetcode.solution32;

/**
 * 3239.最少翻转次数使二进制矩阵回文 I.minimum-number-of-flips-to-make-binary-grid-palindromic-i
 *
 * @author db117
 * @since 2024-11-15 14:50:56
 **/

public class Solution_3239 {
    public static void main(String[] args) {
        Solution solution = new Solution_3239().new Solution();
        // [[1,1,1,1],[0,0,1,0]]
        System.out.println(solution.minFlips(new int[][]{{1, 1, 1, 1}, {0, 0, 1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int rowCount = 0;
            for (int[] arr : grid) {
                for (int j = 0; j < n / 2; j++) {
                    if (arr[j] != arr[n - j - 1]) {
                        rowCount++;
                    }
                }
            }

            int colCount = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m / 2; i++) {
                    if (grid[i][j] != grid[m - i - 1][j]) {
                        colCount++;
                    }
                }
            }
            return Math.min(rowCount, colCount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}