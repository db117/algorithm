

//给你一个 n 个节点的无向带权图，节点编号为 0 到 n - 1 。图中总共有 m 条边，用二维数组 edges 表示，其中 edges[i] = [ai,
// bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。 
//
// 对于节点 0 为出发点，节点 n - 1 为结束点的所有最短路，你需要返回一个长度为 m 的 boolean 数组 answer ，如果 edges[i]
// 至少 在其中一条最短路上，那么 answer[i] 为 true ，否则 answer[i] 为 false 。 
//
// 请你返回数组 answer 。 
//
// 注意，图可能不连通。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4
//,5,2]] 
// 
//
// 输出：[true,true,true,false,true,true,true,false] 
//
// 解释： 
//
// 以下为节点 0 出发到达节点 5 的 所有 最短路： 
//
// 
// 路径 0 -> 1 -> 5 ：边权和为 4 + 1 = 5 。 
// 路径 0 -> 2 -> 3 -> 5 ：边权和为 1 + 1 + 3 = 5 。 
// 路径 0 -> 2 -> 3 -> 1 -> 5 ：边权和为 1 + 1 + 2 + 1 = 5 。 
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]] 
// 
//
// 输出：[true,false,false,true] 
//
// 解释： 
//
// 只有一条从节点 0 出发到达节点 3 的最短路 0 -> 2 -> 3 ，边权和为 1 + 2 = 3 。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 5 * 10⁴ 
// m == edges.length 
// 1 <= m <= min(5 * 10⁴, n * (n - 1) / 2) 
// 0 <= ai, bi < n 
// ai != bi 
// 1 <= wi <= 10⁵ 
// 图中没有重边。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 9 👎 0


package cn.db117.leetcode.solution30;

import java.util.*;

/**
 * 3123.最短路径中的边.find-edges-in-shortest-paths
 *
 * @author db117
 * @since 2024-04-30 11:31:13
 **/

public class Solution_3123 {
    public static void main(String[] args) {
        Solution solution = new Solution_3123().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<int[]>[] graph;
        int n;
        boolean[] ans;
        int m;

        public boolean[] findAnswer(int n, int[][] edges) {
            this.n = n;
            m = edges.length;
            ans = new boolean[m];
            graph = new ArrayList[n];
            visited = new boolean[n];
            inCosts = new long[n];
            Arrays.fill(inCosts, Integer.MAX_VALUE);
            // 图
            Arrays.setAll(graph, i -> new ArrayList<>());
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                graph[edge[0]].add(new int[]{edge[1], edge[2], i});
                graph[edge[1]].add(new int[]{edge[0], edge[2], i});
            }
            for (List<int[]> ints : graph) {
                ints.sort(Comparator.comparingInt(a -> a[1]));
            }

            bfs();
            if (minCost == Integer.MAX_VALUE) {
                return ans;
            }

            dfs(0, 0, new ArrayList<>());

            return ans;
        }

        private void bfs() {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            pq.offer(new long[]{0L, 0L});
            boolean[] visited = new boolean[m];
            while (!pq.isEmpty()) {
                long[] poll = pq.poll();
                long node = poll[0];
                long cost = poll[1];

                if (cost > minCost) {
                    return;
                }
                if (node == n - 1) {
                    minCost = Math.min(minCost, cost);
                }

                for (int[] next : graph[(int) node]) {
                    int nextNode = next[0];
                    int nextCost = next[1];
                    if (nextCost + cost > minCost) {
                        continue;
                    }
                    if (visited[next[2]]) {
                        continue;
                    }
                    visited[next[2]] = true;
                    pq.offer(new long[]{nextNode, nextCost + cost});
                }
            }
        }

        long minCost = Integer.MAX_VALUE;
        boolean[] visited;
        long[] inCosts;

        private void dfs(int node, int cost, List<Integer> path) {
            if (cost > minCost || inCosts[node] < cost) {
                return;
            }
            inCosts[node] = Math.min(inCosts[node], cost);
            if (node == n - 1) {
                path.forEach(i -> ans[i] = true);
                return;
            }

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (visited[nextNode]) {
                    continue;
                }
                visited[node] = true;
                path.add(next[2]);
                dfs(nextNode, cost + nextCost, path);
                path.remove(path.size() - 1);
                visited[node] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}