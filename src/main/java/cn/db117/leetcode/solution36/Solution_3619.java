

//给你一个 m x n 的矩阵 grid 和一个正整数 k。一个 岛屿 是由 正 整数（表示陆地）组成的，并且陆地间 四周 连通（水平或垂直）。 
//
// 一个岛屿的总价值是该岛屿中所有单元格的值之和。 
//
// 返回总价值可以被 k 整除 的岛屿数量。 
//
// 
//
// 示例 1: 
// 
// 
// 输入: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k =
// 5 
// 
//
// 输出: 2 
//
// 解释: 
//
// 网格中包含四个岛屿。蓝色高亮显示的岛屿的总价值可以被 5 整除，而红色高亮显示的岛屿则不能。 
//
//
// 示例 2: 
// 
// 
// 输入: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3 
// 
//
// 输出: 6 
//
// 解释: 
//
// 网格中包含六个岛屿，每个岛屿的总价值都可以被 3 整除。 
//
//
// 
//
// 提示: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 10⁵ 
// 0 <= grid[i][j] <= 10⁶ 
// 1 <= k < = 10⁶ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 18 👎 0


package cn.db117.leetcode.solution36;

/**
 * 3619.总价值可以被 K 整除的岛屿数目.count-islands-with-total-value-divisible-by-k
 *
 * @author db117
 * @since 2026-10-26 17:34:24
 **/

public class Solution_3619 {
    public static void main(String[] args) {
        Solution solution = new Solution_3619().new Solution();
        // [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]]
        //5
        System.out.println(solution.countIslands(new int[][]{{0, 2, 1, 0, 0}, {0, 5, 0, 0, 5}, {0, 0, 1, 0, 0}, {0, 1, 4, 7, 0}, {0, 2, 0, 0, 8}}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 上下左右
        private static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        public int countIslands(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;

            boolean[][] vis = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j]) {
                        continue;
                    }
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    long sum = dfs(grid, vis, i, j);
                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }

            return ans;
        }


        long dfs(int[][] grid, boolean[][] vis, int i, int j) {
            long ans = 0;
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return ans;
            }
            if (vis[i][j]) {
                return ans;
            }
            if (grid[i][j] == 0) {
                return ans;
            }
            vis[i][j] = true;
            ans += grid[i][j];
            for (int[] ints : dir) {
                ans += dfs(grid, vis, i + ints[0], j + ints[1]);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}