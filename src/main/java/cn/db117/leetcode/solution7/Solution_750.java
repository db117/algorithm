

//给定一个只包含 0 和 1 的 m x n 整数矩阵 grid ，返回 其中 「角矩形 」的数量 。 
//
// 一个「角矩形」是由四个不同的在矩阵上的 1 形成的 轴对齐 的矩形。注意只有角的位置才需要为 1。 
//
// 注意：4 个 1 的位置需要是不同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,0,1,0],[0,0,1,0,1],[0,0,0,1,0],[1,0,1,0,1]]
//输出：1
//解释：只有一个角矩形，角的位置为 grid[1][2], grid[1][4], grid[3][2], grid[3][4]。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]]
//输出：9
//解释：这里有 4 个 2x2 的矩形，4 个 2x3 和 3x2 的矩形和 1 个 3x3 的矩形。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：grid = [[1,1,1,1]]
//输出：0
//解释：矩形必须有 4 个不同的角。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// grid[i][j] 不是 0 就是 1 
// 网格中 1 的个数在 [1, 6000] 范围内 
// 
//
// Related Topics 数组 数学 动态规划 矩阵 👍 89 👎 0


package cn.db117.leetcode.solution7;

/**
 * 750.角矩形的数量.number-of-corner-rectangles
 *
 * @author db117
 * @since 2023-10-26 11:24:25
 **/

public class Solution_750 {
    public static void main(String[] args) {
        Solution solution = new Solution_750().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCornerRectangles(int[][] grid) {
            // 选择两行,然后遍历列,看是否都为1
            // 然后就是两行中的两个1组合,就是C(2,n)
            int ans = 0;

            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
                // 选择两行
                for (int j = i + 1; j < row; j++) {
                    int count = 0;
                    // 遍历列
                    for (int k = 0; k < col; k++) {
                        if (grid[i][k] == 1 && grid[j][k] == 1) {
                            count++;
                        }
                    }
                    // 两行中的两个1组合
                    ans += count * (count - 1) / 2;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}