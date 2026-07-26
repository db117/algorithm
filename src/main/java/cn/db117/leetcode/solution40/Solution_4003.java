package cn.db117.leetcode.solution40;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 4003. 交替方向的最小路径代价 III
 */
public class Solution_4003 {

    public static void main(String[] args) {


    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static
    class Solution {
        long inf = Long.MAX_VALUE / 4;

        public long minCost(int m, int n, int[][] penalty) {
            long[][][] dist = new long[m][n][2];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dist[i][j], inf);
                }
            }

            // Dijkstra
            // 状态：[i, j, num, cost]
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[3]));

            dist[0][0][1] = 1;
            pq.add(new long[]{0, 0, 1, 1});

            while (!pq.isEmpty()) {
                long[] poll = pq.poll();

                int i = (int) poll[0];
                int j = (int) poll[1];
                int num = (int) poll[2];
                long cost = poll[3];

                // 这是过期状态
                if (cost != dist[i][j][num]) {
                    continue;
                }

                if (i == m - 1 && j == n - 1) {
                    return cost;
                }

                int nextNum = num ^ 1;

                // up
                if (i > 0) {
                    long newCost = cost + (long) i * (j + 1);

                    // 奇数行动应该向右或向下，向上违反规则
                    if (num == 1) {
                        newCost += penalty[i][j];
                    }

                    if (newCost < dist[i - 1][j][nextNum]) {
                        dist[i - 1][j][nextNum] = newCost;
                        pq.add(new long[]{i - 1, j, nextNum, newCost});
                    }
                }

                // left
                if (j > 0) {
                    long newCost = cost + (long) (i + 1) * j;

                    // 奇数行动向左违反规则
                    if (num == 1) {
                        newCost += penalty[i][j];
                    }

                    if (newCost < dist[i][j - 1][nextNum]) {
                        dist[i][j - 1][nextNum] = newCost;
                        pq.add(new long[]{i, j - 1, nextNum, newCost});
                    }
                }

                // down
                if (i < m - 1) {
                    long newCost = cost + (long) (i + 2) * (j + 1);

                    // 偶数行动应该向左或向上，向下违反规则
                    if (num == 0) {
                        newCost += penalty[i][j];
                    }

                    if (newCost < dist[i + 1][j][nextNum]) {
                        dist[i + 1][j][nextNum] = newCost;
                        pq.add(new long[]{i + 1, j, nextNum, newCost});
                    }
                }

                // right
                if (j < n - 1) {
                    long newCost = cost + (long) (i + 1) * (j + 2);

                    // 偶数行动向右违反规则
                    if (num == 0) {
                        newCost += penalty[i][j];
                    }

                    if (newCost < dist[i][j + 1][nextNum]) {
                        dist[i][j + 1][nextNum] = newCost;
                        pq.add(new long[]{i, j + 1, nextNum, newCost});
                    }
                }

                // wait
                long newCost = cost + penalty[i][j];

                if (newCost < dist[i][j][nextNum]) {
                    dist[i][j][nextNum] = newCost;
                    pq.add(new long[]{i, j, nextNum, newCost});
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
