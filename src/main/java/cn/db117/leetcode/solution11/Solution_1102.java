

//给定一个 m x n 的整数矩阵 grid，返回从 (0,0) 开始到 (m - 1, n - 1) 在四个基本方向上移动的路径的最大 分数 。 
//
// 一条路径的 分数 是该路径上的最小值。 
//
// 
// 例如，路径 8 → 4 → 5 → 9 的得分为 4 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[5,4,5],[1,2,6],[7,4,6]]
//输出：4
//解释：得分最高的路径用黄色突出显示。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
//输出：2 
//
// 示例 3： 
//
// 
//
// 
//输入：grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,
//4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// 0 <= grid[i][j] <= 10⁹ 
// 
//
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 堆（优先队列） 👍 107 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1102.得分最高的路径.path-with-maximum-minimum-value
 *
 * @author db117
 * @since 2023-06-06 10:50:41
 **/

public class Solution_1102 {
    public static void main(String[] args) {
        Solution solution = new Solution_1102().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int maximumMinimumPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] flag = new int[m][n];// 记录每个位置的最大分数，过滤掉无效路径
            for (int[] ints : flag) {
                Arrays.fill(ints, -1);
            }

            // 按照当前路径分数从大到小排序
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
            queue.add(new int[]{0, 0, grid[0][0]});
            flag[0][0] = grid[0][0];
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();// 出队的是分数最高的
                int x = poll[0];
                int y = poll[1];
                int min = poll[2];
                flag[x][y] = Math.max(flag[x][y], min);
                if (x == m - 1 && y == n - 1) {
                    // 到站了
                    return min;
                }

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (min <= flag[nx][ny]) {
                        // 当前路径无效
                        // 只有比之前的分数高的才有意义
                        continue;
                    }
                    // 入队
                    queue.add(new int[]{nx, ny, Math.min(min, grid[nx][ny])});
                }

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}