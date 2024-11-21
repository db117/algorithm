

//大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i *
// n) + j。 
//
// 蛇从单元格 0 开始，并遵循一系列命令移动。 
//
// 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目
//测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。 
//
// 返回执行 commands 后蛇所停留的最终单元格的位置。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 2, commands = ["RIGHT","DOWN"] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：n = 3, commands = ["DOWN","RIGHT","UP"] 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10 
// 1 <= commands.length <= 100 
// commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。 
// 生成的测评数据确保蛇不会移动到矩阵的边界外。 
// 
//
// Related Topics 数组 字符串 模拟 👍 24 👎 0


package cn.db117.leetcode.solution32;

import java.util.List;

/**
 * 3248.矩阵中的蛇.snake-in-matrix
 *
 * @author db117
 * @since 2024-11-21 20:00:44
 **/

public class Solution_3248 {
    public static void main(String[] args) {
        Solution solution = new Solution_3248().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int finalPositionOfSnake(int n, List<String> commands) {
            int x = 0, y = 0;
            for (String command : commands) {
                switch (command) {
                    case "UP" -> y--;
                    case "DOWN" -> y++;
                    case "LEFT" -> x--;
                    case "RIGHT" -> x++;
                }
            }
            return (y) * n + (x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}