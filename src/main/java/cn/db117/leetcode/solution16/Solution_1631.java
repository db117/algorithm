// 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 
// 👍 224 👎 0


package cn.db117.leetcode.solution16;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1631.最小体力消耗路径.path-with-minimum-effort
 *
 * @author db117
 * @since 2021-07-21 14:56:05
 **/

public class Solution_1631 {
    public static void main(String[] args) {
        Solution solution = new Solution_1631().new Solution();

        System.out.println(solution.minimumEffortPath(new int[][]{
                {1, 2, 2}, {3, 8, 2}, {5, 3, 5}
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                {1, 2, 3}, {3, 8, 4}, {5, 3, 5}
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                {1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                {3}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] next = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int minimumEffortPath(int[][] heights) {
            int left = 0, right = 0;
            // 最大高度
            for (int[] height : heights) {
                for (int i : height) {
                    right = Math.max(i, right);
                }
            }

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (check(heights, mid)) {
                    // 可以尝试往小了找
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }


        private boolean check(int[][] heights, int k) {
            int m = heights.length;
            int n = heights[0].length;
            int row, col;
            // 广度优先
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            // 防止走回头路
            Set<Long> set = new HashSet<>();
            while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int cur = heights[poll[0]][poll[1]];

                    if (poll[0] == m - 1 && poll[1] == n - 1) {
                        // 找到符合条件的
                        return true;
                    }

                    for (int[] ints : next) {
                        row = poll[0] + ints[0];
                        col = poll[1] + ints[1];

                        if (row < 0 || row >= m || col < 0 || col >= n) {
                            // 越界
                            continue;
                        }

                        if (Math.abs(heights[row][col] - cur) > k) {
                            // 高度不符合
                            continue;
                        }

                        if (row == m - 1 && col == n - 1) {
                            // 找到符合条件的
                            return true;
                        }

                        if (!set.add((((long) row) << 32) | col)) {
                            // 不走回头路
                            continue;
                        }

                        // 加入队列
                        queue.offer(new int[]{row, col});
                    }
                }

            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}