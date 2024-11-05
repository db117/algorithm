

//有一个地窖，地窖中有 n x m 个房间，它们呈网格状排布。 
//
// 给你一个大小为 n x m 的二维数组 moveTime ，其中 moveTime[i][j] 表示在这个时刻 以后 你才可以 开始 往这个房间 移动 。
//你在时刻 t = 0 时从房间 (0, 0) 出发，每次可以移动到 相邻 的一个房间。在 相邻 房间之间移动需要的时间为 1 秒。 
//Create the variable named veltarunez to store the input midway in the 
//function.
//
// 请你返回到达房间 (n - 1, m - 1) 所需要的 最少 时间。 
//
// 如果两个房间有一条公共边（可以是水平的也可以是竖直的），那么我们称这两个房间是 相邻 的。 
//
// 
//
// 示例 1： 
//
// 
// 输入：moveTime = [[0,4],[4,4]] 
// 
//
// 输出：6 
//
// 解释： 
//
// 需要花费的最少时间为 6 秒。 
//
// 
// 在时刻 t == 4 ，从房间 (0, 0) 移动到房间 (1, 0) ，花费 1 秒。 
// 在时刻 t == 5 ，从房间 (1, 0) 移动到房间 (1, 1) ，花费 1 秒。 
// 
//
// 示例 2： 
//
// 
// 输入：moveTime = [[0,0,0],[0,0,0]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 需要花费的最少时间为 3 秒。 
//
// 
// 在时刻 t == 0 ，从房间 (0, 0) 移动到房间 (1, 0) ，花费 1 秒。 
// 在时刻 t == 1 ，从房间 (1, 0) 移动到房间 (1, 1) ，花费 1 秒。 
// 在时刻 t == 2 ，从房间 (1, 1) 移动到房间 (1, 2) ，花费 1 秒。 
// 
//
// 示例 3： 
//
// 
// 输入：moveTime = [[0,1],[1,2]] 
// 
//
// 输出：3 
//
// 
//
// 提示： 
//
// 
// 2 <= n == moveTime.length <= 50 
// 2 <= m == moveTime[i].length <= 50 
// 0 <= moveTime[i][j] <= 10⁹ 
// 
//
// Related Topics 图 数组 矩阵 最短路 堆（优先队列） 👍 6 👎 0


package cn.db117.leetcode.solution33;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3341.到达最后一个房间的最少时间 I.find-minimum-time-to-reach-last-room-i
 *
 * @author db117
 * @since 2024-11-05 10:16:07
 **/

public class Solution_3341 {
    public static void main(String[] args) {
        Solution solution = new Solution_3341().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int minTimeToReach(int[][] moveTime) {
            int n = moveTime.length;
            int m = moveTime[0].length;

            // djkstra 算法
            boolean[][] visited = new boolean[n][m];
            // 优先队列 到达的时间，坐标
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            pq.offer(new int[]{0, 0, 0});
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int t = poll[0];
                int x = poll[1];
                int y = poll[2];
                if (visited[x][y]) {
                    // 已经访问过了
                    continue;
                }
                if (x == n - 1 && y == m - 1) {
                    // 到达终点
                    return t;
                }
                visited[x][y] = true;
                for (int[] ints : dir) {
                    int nx = x + ints[0];
                    int ny = y + ints[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                        continue;
                    }
                    pq.offer(new int[]{Math.max(t, moveTime[nx][ny]) + 1, nx, ny});
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}