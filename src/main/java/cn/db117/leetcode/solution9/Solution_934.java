

//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 383 👎 0


package cn.db117.leetcode.solution9;

import java.util.*;

/**
 * 934.最短的桥.shortest-bridge
 *
 * @author db117
 * @since 2022-10-25 21:38:06
 **/

public class Solution_934 {
    public static void main(String[] args) {
        Solution solution = new Solution_934().new Solution();
        // [[0,1],[1,0]]
        System.out.println(solution.shortestBridge(new int[][]{{0, 1}, {1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid, next = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int shortestBridge(int[][] grid) {
            this.grid = grid;
            int m = grid.length;
            int n = grid[0].length;


            Queue<int[]> queue = new LinkedList<>();
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        flag = true;
                        // 把第一个岛都标记为 2
                        bfs(i, j, queue);
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            // 标准bfs
            int ans = 0;
            while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    for (int[] ints : next) {
                        int ni = cur[0] + ints[0];
                        int nj = cur[1] + ints[1];
                        if (!check(ni, nj) || grid[ni][nj] == 2) {
                            continue;
                        }

                        if (grid[ni][nj] == 1) {
                            return ans;
                        }
                        grid[ni][nj] = 2;

                        queue.offer(new int[]{ni, nj});
                    }
                }
                ans++;
            }

            return -1;
        }


        private void bfs(int i, int j, Queue<int[]> queue) {
            if (grid[i][j] != 1) {
                return;
            }
            grid[i][j] = 2;
            queue.offer(new int[]{i, j});
            for (int[] ints : next) {
                if (check(i + ints[0], j + ints[1])) {
                    bfs(i + ints[0], j + ints[1], queue);
                }
            }
        }

        private boolean check(int i, int j) {
            return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}