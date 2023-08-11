

//给你一个下标从 0 开始、大小为 n x n 的二维矩阵 grid ，其中 (r, c) 表示： 
//
// 
// 如果 grid[r][c] = 1 ，则表示一个存在小偷的单元格 
// 如果 grid[r][c] = 0 ，则表示一个空单元格 
// 
//
// 你最开始位于单元格 (0, 0) 。在一步移动中，你可以移动到矩阵中的任一相邻单元格，包括存在小偷的单元格。 
//
// 矩阵中路径的 安全系数 定义为：从路径中任一单元格到矩阵中任一小偷所在单元格的 最小 曼哈顿距离。 
//
// 返回所有通向单元格 (n - 1, n - 1) 的路径中的 最大安全系数 。 
//
// 单元格 (r, c) 的某个 相邻 单元格，是指在矩阵中存在的 (r, c + 1)、(r, c - 1)、(r + 1, c) 和 (r - 1, c)
// 之一。 
//
// 两个单元格 (a, b) 和 (x, y) 之间的 曼哈顿距离 等于 | a - x | + | b - y | ，其中 |val| 表示 val 的绝对
//值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
//输出：0
//解释：从 (0, 0) 到 (n - 1, n - 1) 的每条路径都经过存在小偷的单元格 (0, 0) 和 (n - 1, n - 1) 。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,1],[0,0,0],[0,0,0]]
//输出：2
//解释：
//上图所示路径的安全系数为 2：
//- 该路径上距离小偷所在单元格（0，2）最近的单元格是（0，0）。它们之间的曼哈顿距离为 | 0 - 0 | + | 0 - 2 | = 2 。
//可以证明，不存在安全系数更高的其他路径。
// 
//
// 示例 3： 
// 
// 
//输入：grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
//输出：2
//解释：
//上图所示路径的安全系数为 2：
//- 该路径上距离小偷所在单元格（0，3）最近的单元格是（1，2）。它们之间的曼哈顿距离为 | 0 - 1 | + | 3 - 2 | = 2 。
//- 该路径上距离小偷所在单元格（3，0）最近的单元格是（3，2）。它们之间的曼哈顿距离为 | 3 - 3 | + | 0 - 2 | = 2 。
//可以证明，不存在安全系数更高的其他路径。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == n <= 400 
// grid[i].length == n 
// grid[i][j] 为 0 或 1 
// grid 至少存在一个小偷 
// 
//
// Related Topics 广度优先搜索 并查集 数组 二分查找 矩阵 👍 23 👎 0


package cn.db117.leetcode.solution28;

import java.util.*;

/**
 * 2812.找出最安全路径.find-the-safest-path-in-a-grid
 *
 * @author db117
 * @since 2023-08-11 10:54:57
 **/

public class Solution_2812 {
    public static void main(String[] args) {
        Solution solution = new Solution_2812().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int maximumSafenessFactor(List<List<Integer>> grid) {
            // 找到所有位置于小偷的最小距离
            int n = grid.size();
            int[][] dp = new int[n][n];
            // 初始化
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            Queue<int[]> queue = new ArrayDeque<>();
            // 找到所有小偷的位置
            for (int i = 0; i < n; i++) {
                List<Integer> list = grid.get(i);
                for (int j = 0; j < n; j++) {
                    if (list.get(j) == 1) {
                        // 找到所有小偷的位置
                        queue.add(new int[]{i, j});
                        dp[i][j] = 0;
                    }
                }
            }

            // bfs
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (dp[nx][ny] != Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[nx][ny] = dp[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }

            // Dijkstra
            // 找到最大的安全系数
            int ans = Math.min(dp[n - 1][n - 1], dp[0][0]);
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(ints -> -dp[ints[0]][ints[1]]));
            pq.add(new int[]{0, 0});
            boolean[][] vis = new boolean[n][n];
            vis[0][0] = true;
            while (!pq.isEmpty()) {
                // 每次都取最大的
                int[] poll = pq.poll();
                int x = poll[0], y = poll[1];
                if (x == n - 1 && y == n - 1) {
                    break;
                }
                ans = Math.min(ans, dp[x][y]);

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (vis[nx][ny]) {
                        continue;
                    }
                    vis[nx][ny] = true;

                    pq.add(new int[]{nx, ny});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}