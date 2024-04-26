

//Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 哈希函数 👍 177 👎 0


package cn.db117.leetcode.solution6;

import java.util.HashSet;
import java.util.Set;

/**
 * 694.不同岛屿的数量.number-of-distinct-islands
 *
 * @author db117
 * @since 2024-04-25 10:00:18
 **/

public class Solution_694 {
    public static void main(String[] args) {
        Solution solution = new Solution_694().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            Set<String> set = new HashSet<>();
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 每个岛屿的路径
                        StringBuilder builder = new StringBuilder();
                        dfs(grid, i, j, builder);
                        set.add(builder.toString());
                    }
                }
            }

            return set.size();
        }

        private void dfs(int[][] grid, int i, int j, StringBuilder builder) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
                return;
            }
            // 标记已经访问
            grid[i][j] = 0;
            // 记录路径
            dfs(grid, i + 1, j, builder.append("D"));
            dfs(grid, i - 1, j, builder.append("U"));
            dfs(grid, i, j + 1, builder.append("R"));
            dfs(grid, i, j - 1, builder.append("L"));

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}