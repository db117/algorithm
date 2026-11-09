

//给你一个整数 n，表示一棵有 n 个节点的树，节点编号从 0 到 n - 1，并且树以节点 0 为 根节点。这棵树由一个长度为 n - 1 的二维数组 
//edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间存在一条 无向 边。 
//
// 另给你一个长度为 n 的字符串 colors，其中 colors[i] 表示节点 i 的颜色：'R' 表示红色，'B' 表示蓝色。 
//
// 你可以 翻转 任意节点的颜色：从 'R' 变为 'B'，或从 'B' 变为 'R'。翻转节点 u 的代价等于以节点 u 为根的子树的大小。 
//
// 你的目标是通过翻转颜色，使所有 红色 节点在树中形成 一个连通分量 。蓝色节点可以不连通。没有红色节点的配置也视为有效。 
//
// 返回实现这一目标所需的 最小总代价 。 
//
// 在有根树中，节点 v 的子树是由所有到根节点的路径经过 v 的节点组成的集合。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 3, colors = "RBR", edges = [[0,1],[1,2]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
//
// 
// 有两个红色节点（0 和 2），它们彼此不连通。 
// 可以将节点 2 从 'R'（红色）翻转为 'B'（蓝色）。节点 2 的子树大小为 1，因此代价为 1。 
// 翻转后，只有节点 0 仍为红色，恰好形成一个红色连通分量。 
// 
//
//
// 示例 2： 
//
// 
// 输入： n = 3, colors = "RBR", edges = [[0,1],[0,2]] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 
//
// 
// 有两个红色节点（0 和 2），它们已经彼此连通。 
// 所有红色节点已经形成一个连通分量，因此无须翻转。最小总代价为 0。 
// 
//
//
// 示例 3： 
//
// 
// 输入： n = 4, colors = "BRRR", edges = [[0,1],[0,2],[0,3]] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 
//
// 
// 有三个红色节点（1、2 和 3），它们彼此不连通。 
// 这三个红色节点都是叶节点，且互不连通。 
// 为了得到一个红色连通分量，保留一个红色叶节点，并将另外两个翻转为蓝色。 
// 每个叶节点的子树大小均为 1，因此翻转其中任意两个的总代价为 2。 
// 
//
//
// 示例 4： 
//
// 
// 输入： n = 3, colors = "BBB", edges = [[0,1],[1,2]] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 
//
// 
// 所有节点均为蓝色，因此没有红色节点。 
// 空的红色节点集合也视为一个连通分量，因此当前状态已经有效，代价为 0。 
// 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// n == colors.length 
// colors[i] 为 'R' 或 'B'。 
// edges.length == n - 1 
// edges[i] = [ui, vi] 
// 0 <= ui, vi <= n - 1 
// 输入保证 edges 表示一棵有效的树。 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4108.使红色节点连通的最小代价.minimum-cost-to-make-red-nodes-connected
 *
 * @author db117
 * @since 2026-11-09 22:22:07
 **/

public class Solution_4108 {
    public static void main(String[] args) {
        Solution solution = new Solution_4108().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minCost(int n, String colors, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            // 每个节点为根的子树的大小
            int[] size = new int[n];
            dfsDeep(0, -1, size, graph);

            // 全部蓝色的代价
            long allBlue = 0;
            for (int i = 0; i < n; i++) {
                if (colors.charAt(i) == 'R') {
                    allBlue += size[i];
                }
            }
            long[] dp = new long[n];
            Arrays.fill(dp, Long.MAX_VALUE);

            dfs(0, -1, dp, size, graph, colors);
            long max = Math.max(0, Arrays.stream(dp).max().getAsLong());// 可能为负数
            return allBlue - max;
        }

        long dfs(int i, int parent, long[] dp, int[] size, List<List<Integer>> graph, String colors) {
            if (dp[i] != Long.MAX_VALUE) {
                return dp[i];
            }
            // 子节点
            List<Integer> next = graph
                    .get(i)
                    .stream()
                    .filter(j -> j != parent).toList();

            // 记录权重，红色正数，蓝色负数
            // 最后是找权重最大的，即红色最多的
            if (colors.charAt(i) == 'B') {
                dp[i] = -size[i];
            } else {
                dp[i] = size[i];
            }
            if (next.isEmpty()) {
                return dp[i];
            }

            for (int j : next) {
                long dfs = dfs(j, i, dp, size, graph, colors);
                if (dfs > 0) {
                    // 只有子节点的权重是正数才计入连通分量
                    dp[i] += dfs;
                }
            }
            return dp[i];
        }

        int dfsDeep(int i, int parent, int[] deepArr, List<List<Integer>> graph) {
            List<Integer> integers = graph.get(i);
            int count = 1;
            for (int k : integers) {
                if (k != parent) {
                    count += dfsDeep(k, i, deepArr, graph);
                }
            }
            deepArr[i] = count;
            return count;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}