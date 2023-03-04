

//给你一个 m x n 的矩阵 grid ，每个元素都为 非负 整数，其中 grid[row][col] 表示可以访问格子 (row, col) 的 最早 时
//间。也就是说当你访问格子 (row, col) 时，最少已经经过的时间为 grid[row][col] 。 
//
// 你从 最左上角 出发，出发时刻为 0 ，你必须一直移动到上下左右相邻四个格子中的 任意 一个格子（即不能停留在格子上）。每次移动都需要花费 1 单位时间。
// 
//
// 请你返回 最早 到达右下角格子的时间，如果你无法到达右下角的格子，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
//输出：7
//解释：一条可行的路径为：
//- 时刻 t = 0 ，我们在格子 (0,0) 。
//- 时刻 t = 1 ，我们移动到格子 (0,1) ，可以移动的原因是 grid[0][1] <= 1 。
//- 时刻 t = 2 ，我们移动到格子 (1,1) ，可以移动的原因是 grid[1][1] <= 2 。
//- 时刻 t = 3 ，我们移动到格子 (1,2) ，可以移动的原因是 grid[1][2] <= 3 。
//- 时刻 t = 4 ，我们移动到格子 (1,1) ，可以移动的原因是 grid[1][1] <= 4 。
//- 时刻 t = 5 ，我们移动到格子 (1,2) ，可以移动的原因是 grid[1][2] <= 5 。
//- 时刻 t = 6 ，我们移动到格子 (1,3) ，可以移动的原因是 grid[1][3] <= 6 。
//- 时刻 t = 7 ，我们移动到格子 (2,3) ，可以移动的原因是 grid[2][3] <= 7 。
//最终到达时刻为 7 。这是最早可以到达的时间。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,2,4],[3,2,1],[1,0,4]]
//输出：-1
//解释：没法从左上角按题目规定走到右下角。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 0 <= grid[i][j] <= 10⁵ 
// grid[0][0] == 0 
// 
//
// 👍 16 👎 0


package cn.db117.leetcode.solution25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2577.在网格图中访问一个格子的最少时间.minimum-time-to-visit-a-cell-in-a-grid
 *
 * @author db117
 * @since 2023-02-27 14:29:16
 **/

public class Solution_2577 {
    public static void main(String[] args) {
        Solution solution = new Solution_2577().new Solution();
        System.out.println(solution.minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int minimumTime(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            if (grid[0][1] > 1 && grid[1][0] > 1) {
                // 直接堵死了
                return -1;
            }
            // Dijkstra
            // [到达的时间，i，j]
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            queue.add(new int[]{0, 0, 0});// 初始位置
            int[][] md = new int[m][n];// 最短距离
            for (int[] ints : md) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            md[0][0] = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int d = poll[0];
                int i = poll[1];
                int j = poll[2];
                if (i == m - 1 && j == n - 1) {
                    return d;
                }

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                        continue;
                    }
                    int nd = Math.max(grid[ni][nj], d + 1);
                    // 必须要和 ni+nj 同奇偶，这个矩阵步数的奇偶性和 i+j 相关
                    nd += (nd - ni - nj) % 2;
                    if (nd < md[ni][nj]) {
                        md[ni][nj] = nd;// 只有第一次会更新该节点，后面的进不来
                        queue.offer(new int[]{nd, ni, nj});
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}