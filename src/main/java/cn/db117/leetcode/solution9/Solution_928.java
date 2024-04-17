

//给定一个由 n 个节点组成的网络，用 n x n 个邻接矩阵 graph 表示。在节点网络中，只有当 graph[i][j] = 1 时，节点 i 能够直接
//连接到另一个节点 j。 
//
// 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传
//播将继续，直到没有更多的节点可以被这种方式感染。 
//
// 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 
//
// 我们可以从 initial 中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。 
//
// 请返回移除后能够使 M(initial) 最小化的节点。如果有多个节点满足条件，返回索引 最小的节点 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// n == graph.length 
// n == graph[i].length 
// 2 <= n <= 300 
// graph[i][j] 是 0 或 1. 
// graph[i][j] == graph[j][i] 
// graph[i][i] == 1 
// 1 <= initial.length < n 
// 0 <= initial[i] <= n - 1 
// initial 中每个整数都不同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 哈希表 👍 75 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;

/**
 * 928.尽量减少恶意软件的传播 II.minimize-malware-spread-ii
 *
 * @author db117
 * @since 2024-04-17 10:50:22
 **/

public class Solution_928 {
    public static void main(String[] args) {
        Solution solution = new Solution_928().new Solution();

        // [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]]
        //			[0,1]
//        System.out.println(solution.minMalwareSpread(new int[][]{
//                {1, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 1, 1},
//                {0, 0, 1, 1}
//        }, new int[]{0, 1}));

        // graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//        System.out.println(solution.minMalwareSpread(new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        }, new int[]{0, 1}));

        // [[1,1,0,0],[1,1,0,1],[0,0,1,0],[0,1,0,1]]
        //			[3,0]
        System.out.println(solution.minMalwareSpread(new int[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1}
        }, new int[]{3, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 节点id 状态机  -1 未访问 -2 找到多个 >=0 找到一个
        int nodeId;
        // 记录当前节点的连通分量
        int size;

        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;
            boolean[] visited = new boolean[n];
            boolean[] isInitial = new boolean[n];
            for (int i : initial) {
                isInitial[i] = true;
            }

            // 记录每一个initial中的节点移除后不会被感染的节点数量
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                if (visited[i] || isInitial[i]) {
                    // 已经访问过或者是initial节点
                    continue;
                }

                nodeId = -1;
                size = 0;
                // 找一下当前节点的连通分量，如果只有一个initial节点则记录
                dfs(i, graph, visited, isInitial);
                if (nodeId >= 0) {
                    // 记录只找到一个initial节点的连通分量
                    count[nodeId] += size;
                }
            }

            // 找答案
            Arrays.sort(initial);
            int res = initial[0];
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (isInitial[i]) {
                    if (count[i] > max) {
                        max = count[i];
                        res = i;
                    }
                }
            }
            return res;
        }

        private void dfs(int i, int[][] graph, boolean[] visited, boolean[] isInitial) {
            visited[i] = true;
            size++;

            for (int j = 0; j < graph[i].length; j++) {
                if (i == j || graph[i][j] == 0 || visited[j]) {
                    continue;
                }


                if (isInitial[j]) {
                    // 状态机
                    // -1 未访问 -2 找到多个 >=0 找到一个
                    if (nodeId != -2 && nodeId != j) {
                        if (nodeId == -1) {
                            nodeId = j;
                        } else {
                            nodeId = -2;
                        }
                    }
                } else {
                    dfs(j, graph, visited, isInitial);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}