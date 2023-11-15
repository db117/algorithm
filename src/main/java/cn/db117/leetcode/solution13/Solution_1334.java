

//有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 
//fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。 
//
// 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。 
//
// 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
//输出：3
//解释：城市分布图如上。
//每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
//城市 0 -> [城市 1, 城市 2] 
//城市 1 -> [城市 0, 城市 2, 城市 3] 
//城市 2 -> [城市 0, 城市 1, 城市 3] 
//城市 3 -> [城市 1, 城市 2] 
//城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], 
//distanceThreshold = 2
//输出：0
//解释：城市分布图如上。 
//每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
//城市 0 -> [城市 1] 
//城市 1 -> [城市 0, 城市 4] 
//城市 2 -> [城市 3, 城市 4] 
//城市 3 -> [城市 2, 城市 4]
//城市 4 -> [城市 1, 城市 2, 城市 3] 
//城市 0 在阈值距离 2 以内只有 1 个邻居城市。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 3 
// 0 <= fromi < toi < n 
// 1 <= weighti, distanceThreshold <= 10^4 
// 所有 (fromi, toi) 都是不同的。 
// 
//
// Related Topics 图 动态规划 最短路 👍 175 👎 0


package cn.db117.leetcode.solution13;

import java.util.Arrays;

/**
 * 1334.阈值距离内邻居最少的城市.find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 *
 * @author db117
 * @since 2023-11-15 15:17:34
 **/

public class Solution_1334 {
    public static void main(String[] args) {
        Solution solution = new Solution_1334().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] d;// 两个点之间的距离
        int[][][] memo;

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            d = new int[n][n];
            memo = new int[n][n][n];
            for (int[][] ints : memo) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, -1);
                }
            }
            for (int[] ints : d) {
                Arrays.fill(ints, Integer.MAX_VALUE / 2);// 防止溢出
            }
            for (int[] edge : edges) {
                d[edge[0]][edge[1]] = edge[2];
                d[edge[1]][edge[0]] = edge[2];
            }
            int ans = 0;
            int min = Integer.MAX_VALUE;
            // 拆分子任务
            // 任意两点之间的最短距离
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && dfs(n - 1, i, j) <= distanceThreshold) {// 任意两点之间的最短距离小于阈值
                        count++;
                    }
                }
                if (count <= min) {// 大于等于是因为要返回最大的
                    min = count;
                    ans = i;
                }
            }
            return ans;
        }

        // 经过 k 的情况下,i j 的最短距离
        public int dfs(int k, int i, int j) {
            if (k < 0) {
                return d[i][j];
            }
            if (memo[k][i][j] != -1) {
                return memo[k][i][j];
            }
            return memo[k][i][j] = Math.min(dfs(k - 1, i, j),// 不选择节点 k
                    dfs(k - 1, i, k) + dfs(k - 1, k, j)// 选择节点 k ,那么就是 i->k + k->j
            );
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}