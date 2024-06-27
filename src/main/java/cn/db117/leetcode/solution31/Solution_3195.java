

//给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。 
//
// 返回这个矩形可能的 最小 面积。 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[0,1,0],[1,0,1]] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。 
//
// 示例 2： 
//
// 
// 输入： grid = [[0,0],[1,0]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 1000 
// grid[i][j] 是 0 或 1。 
// 输入保证 grid 中至少有一个 1 。 
// 
//
// Related Topics 数组 矩阵 👍 1 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3195.包含所有 1 的最小矩形面积 I.find-the-minimum-area-to-cover-all-ones-i
 *
 * @author db117
 * @since 2024-06-27 17:44:27
 **/

public class Solution_3195 {
    public static void main(String[] args) {
        Solution solution = new Solution_3195().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumArea(int[][] grid) {
            int ans = 0;
            int m = grid.length;
            int n = grid[0].length;
            // 找到 1 出现的最小，最大列行
            int top = m, bottom = 0, left = n, right = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        top = Math.min(top, i);
                        bottom = Math.max(bottom, i);
                        left = Math.min(left, j);
                        right = Math.max(right, j);
                    }
                }
            }
            return (right - left + 1) * (bottom - top + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}