

//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 874 👎 0


package cn.db117.leetcode.solution9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994.腐烂的橘子.rotting-oranges
 *
 * @author db117
 * @since 2024-05-13 23:30:35
 **/

public class Solution_994 {
    public static void main(String[] args) {
        Solution solution = new Solution_994().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] temp = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 统计新鲜橘子数量
                    if (grid[i][j] == 1) {
                        count++;
                    } else if (grid[i][j] == 2) {
                        // 腐烂的橘子
                        queue.add(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            while (count > 0 && !queue.isEmpty()) {
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    // 上下左右
                    for (int[] ints : temp) {
                        int newX = x + ints[0];
                        int newY = y + ints[1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                            // 新鲜橘子变腐烂
                            grid[newX][newY] = 2;
                            count--;
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            return count == 0 ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}