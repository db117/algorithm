//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 372 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer 47.礼物的最大价值.li-wu-de-zui-da-jie-zhi-lcof
 *
 * @author db117
 * @since 2023-03-08 00:23:02
 **/

public class Offer_47 {
    public static void main(String[] args) {
        Solution solution = new Offer_47().new Solution();
        System.out.println(solution.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // init
            for (int i = 1; i < m; i++) {
                grid[i][0] += grid[i - 1][0];
            }
            for (int i = 1; i < n; i++) {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 选左边 上边最大的那个
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}