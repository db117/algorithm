

//给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，其中 
//values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，其中 edges[j] = [uj, vj, timej] 表示
//节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。 
//
// 合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。你可以访问一个节点任意次。一条合法
//路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。 
//
// 请你返回一条合法路径的 最大 价值。 
//
// 注意：每个节点 至多 有 四条 边与之相连。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
//输出：75
//解释：
//一条可能的路径为：0 -> 1 -> 0 -> 3 -> 0 。总花费时间为 10 + 10 + 10 + 10 = 40 <= 49 。
//访问过的节点为 0 ，1 和 3 ，最大路径价值为 0 + 32 + 43 = 75 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30
//输出：25
//解释：
//一条可能的路径为：0 -> 3 -> 0 。总花费时间为 10 + 10 = 20 <= 30 。
//访问过的节点为 0 和 3 ，最大路径价值为 5 + 20 = 25 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], maxTime 
//= 50
//输出：7
//解释：
//一条可能的路径为：0 -> 1 -> 3 -> 1 -> 0 。总花费时间为 10 + 13 + 13 + 10 = 46 <= 50 。
//访问过的节点为 0 ，1 和 3 ，最大路径价值为 1 + 2 + 4 = 7 。 
//
// 示例 4： 
//
// 
//
// 
//输入：values = [0,1,2], edges = [[1,2,10]], maxTime = 10
//输出：0
//解释：
//唯一一条路径为 0 。总花费时间为 0 。
//唯一访问过的节点为 0 ，最大路径价值为 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length 
// 1 <= n <= 1000 
// 0 <= values[i] <= 10⁸ 
// 0 <= edges.length <= 2000 
// edges[j].length == 3 
// 0 <= uj < vj <= n - 1 
// 10 <= timej, maxTime <= 100 
// [uj, vj] 所有节点对 互不相同 。 
// 每个节点 至多有四条 边。 
// 图可能不连通。 
// 
// Related Topics 图 数组 回溯 👍 12 👎 0


package cn.db117.leetcode.solution20;

import java.util.ArrayList;
import java.util.List;

/**
 * 2065.最大化一张图中的路径价值.maximum-path-quality-of-a-graph
 *
 * @author db117
 * @since 2021-11-10 16:51:49
 **/

public class Solution_2065 {
    public static void main(String[] args) {
        Solution solution = new Solution_2065().new Solution();

        System.out.println(solution.maximalPathQuality(new int[]{0, 32, 10, 43}, new int[][]{{0, 1, 10}, {1, 2, 15}, {0, 3, 10}}, 49));
        System.out.println(solution.maximalPathQuality(new int[]{5, 10, 15, 20}, new int[][]{{0, 1, 10}, {1, 2, 10}, {0, 3, 10}}, 30));
        System.out.println(solution.maximalPathQuality(new int[]{1, 2, 3, 4}, new int[][]{{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}}, 50));
        System.out.println(solution.maximalPathQuality(new int[]{0, 1, 2}, new int[][]{{1, 2, 10}}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            // 邻接表
            List<int[]>[] graph = new List[values.length];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>(4);
            }
            for (int[] edge : edges) {
                graph[edge[0]].add(new int[]{edge[1], edge[2]});
                graph[edge[1]].add(new int[]{edge[0], edge[2]});
            }

            int[] max = new int[1];
            // 从 0 开始
            int[] count = new int[values.length];
            count[0]++;
            dfs(values, graph, maxTime, max, count, 0, values[0]);
            return max[0];
        }

        /**
         * dfs
         *
         * @param values   节点值
         * @param graphs   邻接表
         * @param time     时间
         * @param max      最大值
         * @param count    每一个节点出现的次数
         * @param curIndex 当前节点
         * @param curSum   当前总和
         */
        public void dfs(int[] values, List<int[]>[] graphs, int time, int[] max, int[] count, int curIndex, int curSum) {
            if (time < 0) {
                // 没有时间了
                return;
            }
            if (curIndex == 0) {
                // 到 0 了，计算一下
                max[0] = Math.max(max[0], curSum);
            }

            count[curIndex]++;
            if (count[curIndex] == 1) {
                // 每一个节点只处理一次
                curSum += values[curIndex];
            }
            for (int[] next : graphs[curIndex]) {
                // 继续走
                dfs(values, graphs, time - next[1], max, count, next[0], curSum);
            }
            // 回溯
            count[curIndex]--;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}