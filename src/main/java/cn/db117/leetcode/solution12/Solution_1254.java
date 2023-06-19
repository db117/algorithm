

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 237 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1254.统计封闭岛屿的数目.number-of-closed-islands
 *
 * @author db117
 * @since 2023-06-18 21:29:27
 **/

public class Solution_1254 {
    public static void main(String[] args) {
        Solution solution = new Solution_1254().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] flag;
        boolean cur;

        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.grid = grid;
            flag = new boolean[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (flag[i][j]) {
                        continue;
                    }
                    if (grid[i][j] == 0) {
                        // 每一个岛屿都是封闭的，走一波
                        cur = true;// 默认是封闭的
                        dfs(i, j);
                        if (cur) {
                            // 走玩了没有碰到边界，说明是封闭的
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }

        private void dfs(int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                cur = false;
                return;
            }
            if (flag[i][j]) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }
            flag[i][j] = true;

            for (int[] ints : d) {
                int x = i + ints[0];
                int y = j + ints[1];
                dfs(x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}