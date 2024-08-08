

//给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。字符 'W' 表示白色，字符 'B' 表示黑色。 
//
// 你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
// 
//
// 如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。 
//
// 
// 
// 
// 示例 1： 
//
// 
// 
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 输入：grid = [["B","W","B"],["B","W","W"],["B","W","B"]] 
// 
//
// 输出：true 
//
// 解释： 
//
// 修改 grid[0][2] 的颜色，可以满足要求。 
//
// 示例 2： 
//
// 
// 
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 输入：grid = [["B","W","B"],["W","B","W"],["B","W","B"]] 
// 
//
// 输出：false 
//
// 解释： 
//
// 只改变一个格子颜色无法满足要求。 
//
// 示例 3： 
//
// 
// 
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 
// 
//
// 
// 输入：grid = [["B","W","B"],["B","W","W"],["B","W","W"]] 
// 
//
// 输出：true 
//
// 解释： 
//
// grid 已经包含一个 2 x 2 颜色相同的正方形了。
// 
//
// 
//
// 提示： 
//
// 
// grid.length == 3 
// grid[i].length == 3 
// grid[i][j] 要么是 'W' ，要么是 'B' 。 
// 
//
// Related Topics 数组 枚举 矩阵 👍 1 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3127.构造相同颜色的正方形.make-a-square-with-the-same-color
 *
 * @author db117
 * @since 2024-08-08 17:53:20
 **/

public class Solution_3127 {
    public static void main(String[] args) {
        Solution solution = new Solution_3127().new Solution();
        // [["B","W","B"],["W","B","W"],["B","W","B"]]
        System.out.println(solution.canMakeSquare(new char[][]{
                {'B', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'B'}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeSquare(char[][] grid) {
            // 一共就有4个正方形
            return count(grid, 0, 0, 1, 1) ||
                    count(grid, 0, 1, 1, 2) ||
                    count(grid, 1, 0, 2, 1) ||
                    count(grid, 1, 1, 2, 2);
        }

        public boolean count(char[][] grid, int i_start, int j_start, int i_end, int j_end) {
            int count = 0;
            for (int i = i_start; i <= i_end; i++) {
                for (int j = j_start; j <= j_end; j++) {
                    if (grid[i][j] == 'W') {
                        count++;
                    }
                }
            }
            // 只有不是 2 个格子一样就都可以在改变一个的情况下都变成一种颜色
            return count != 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}