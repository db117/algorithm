

//给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。 
//
// 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 10⁹ + 7 取余 后返
//回。 
//
// 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,1],[3,4]]
//输出：8
//解释：严格递增路径包括：
//- 长度为 1 的路径：[1]，[1]，[3]，[4] 。
//- 长度为 2 的路径：[1 -> 3]，[1 -> 4]，[3 -> 4] 。
//- 长度为 3 的路径：[1 -> 3 -> 4] 。
//路径数目为 4 + 3 + 1 = 8 。
// 
//
// 示例 2： 
//
// 输入：grid = [[1],[2]]
//输出：3
//解释：严格递增路径包括：
//- 长度为 1 的路径：[1]，[2] 。
//- 长度为 2 的路径：[1 -> 2] 。
//路径数目为 2 + 1 = 3 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 18 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2328.网格图中递增路径的数目.number-of-increasing-paths-in-a-grid
 *
 * @author db117
 * @since 2022-07-13 18:39:06
 **/

public class Solution_2328 {
    public static void main(String[] args) {
        Solution solution = new Solution_2328().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 1000000007;
        int[][] dips = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int countPaths(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            int[][] dp = new int[m][n];
            for (int[] ints : dp) {
                // 初始化 dp,每一个格子都可以算一个
                Arrays.fill(ints, 1);
            }

            // x,y,val  对值进行排序
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    queue.offer(new int[]{i, j, grid[i][j]});
                }
            }

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                int val = poll[2];

                // 旁边 4 个格子
                for (int[] dip : dips) {
                    int nx = x + dip[0];
                    int ny = y + dip[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    // 如果旁边的格子比当前的小,就加上
                    if (val > grid[nx][ny]) {
                        dp[x][y] += dp[nx][ny];
                        dp[x][y] %= mod;
                    }
                }

                // 加上当前格子
                ans += dp[x][y];
                ans %= mod;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}