

//给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。 
//
// 当你在格子 (i, j) 的时候，你可以移动到以下格子之一： 
//
// 
// 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者 
// 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。 
// 
//
// 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
//输出：4
//解释：上图展示了到达右下角格子经过的 4 个格子。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
//输出：3
//解释：上图展示了到达右下角格子经过的 3 个格子。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[2,1,0],[1,0,0]]
//输出：-1
//解释：无法到达右下角格子。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 0 <= grid[i][j] < m * n 
// grid[m - 1][n - 1] == 0 
// 
//
// Related Topics 栈 广度优先搜索 并查集 数组 动态规划 矩阵 单调栈 堆（优先队列） 👍 49 👎 0


package cn.db117.leetcode.solution26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2617.网格图中最少访问的格子数.minimum-number-of-visited-cells-in-a-grid
 *
 * @author db117
 * @since 2024-03-22 16:01:44
 **/

public class Solution_2617 {
    public static void main(String[] args) {
        Solution solution = new Solution_2617().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumVisitedCells(int[][] grid) {
            int ans = Integer.MAX_VALUE;
            int m = grid.length, n = grid[0].length;
            PriorityQueue<int[]>[] colPq = new PriorityQueue[n];
            Arrays.setAll(colPq, i -> new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0])));
            PriorityQueue<int[]> row = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < m; i++) {
                // 从上往下
                row.clear();// 前面的不会再被访问了,清空
                for (int j = 0; j < n; j++) {
                    int step;
                    if (i == 0 && j == 0) {
                        // 起点
                        step = 1;
                    } else {
                        step = Integer.MAX_VALUE;
                    }

                    PriorityQueue<int[]> col = colPq[j];
                    while (!row.isEmpty() && row.peek()[1] < j) {
                        // 到不了当前行
                        row.poll();
                    }
                    while (!col.isEmpty() && col.peek()[1] < i) {
                        // 到不了当前列
                        col.poll();
                    }

                    if (!row.isEmpty()) {
                        // 从上面过来
                        step = Math.min(step, row.peek()[0] + 1);
                    }
                    if (!col.isEmpty()) {
                        // 从左边过来
                        step = Math.min(step, col.peek()[0] + 1);
                    }

                    if (grid[i][j] > 0 && step < Integer.MAX_VALUE) {
                        col.offer(new int[]{step, grid[i][j] + i});
                        row.offer(new int[]{step, grid[i][j] + j});
                    }


                    if (i == m - 1 && j == n - 1) {
                        // 终点
                        return step < Integer.MAX_VALUE ? step : -1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}