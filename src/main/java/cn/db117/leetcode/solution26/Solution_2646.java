

//现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 
//edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。 
//
// 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。 
//
// 给定路径的 价格总和 是该路径上所有节点的价格之和。 
//
// 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何
//你喜欢的路径前往节点 endi 。 
//
// 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。 
//
// 返回执行所有旅行的最小价格总和。 
//
// 
//
// 示例 1： 
// 输入：n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,
//1],[2,3]]
//输出：23
//解释：
//上图表示将节点 2 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 、2 和 3 并使其价格减半后的树。
//第 1 次旅行，选择路径 [0,1,3] 。路径的价格总和为 1 + 2 + 3 = 6 。
//第 2 次旅行，选择路径 [2,1] 。路径的价格总和为 2 + 5 = 7 。
//第 3 次旅行，选择路径 [2,1,3] 。路径的价格总和为 5 + 2 + 3 = 10 。
//所有旅行的价格总和为 6 + 7 + 10 = 23 。可以证明，23 是可以实现的最小答案。 
//
// 示例 2： 
// 输入：n = 2, edges = [[0,1]], price = [2,2], trips = [[0,0]]
//输出：1
//解释：
//上图表示将节点 0 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 并使其价格减半后的树。 
//第 1 次旅行，选择路径 [0] 。路径的价格总和为 1 。 
//所有旅行的价格总和为 1 。可以证明，1 是可以实现的最小答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// edges.length == n - 1 
// 0 <= ai, bi <= n - 1 
// edges 表示一棵有效的树 
// price.length == n 
// price[i] 是一个偶数 
// 1 <= price[i] <= 1000 
// 1 <= trips.length <= 100 
// 0 <= starti, endi <= n - 1 
// 
//
// Related Topics 树 深度优先搜索 数组 动态规划 👍 25 👎 0


package cn.db117.leetcode.solution26;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2646.最小化旅行的价格总和.minimize-the-total-price-of-the-trips
 *
 * @author db117
 * @since 2023-04-24 10:29:06
 **/

public class Solution_2646 {
    public static void main(String[] args) {
        Solution solution = new Solution_2646().new Solution();
        // n =
        //4
        //edges =
        //[[0,1],[1,2],[1,3]]
        //price =
        //[2,2,10,6]
        //trips =
        //[[0,3],[2,1],[2,3]]
        System.out.println(solution.minimumTotalPrice(4,
                new int[][]{{0, 1}, {1, 2}, {1, 3}},
                new int[]{2, 2, 10, 6},
                new int[][]{{0, 3}, {2, 1}, {2, 3}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<Integer>[] graph;
        int[] total;
        int[] price;

        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
            // 建图
            graph = new ArrayList[n];
            this.price = price;
            Arrays.setAll(graph, value -> new ArrayList<>());

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            total = new int[n];
            // 找到所有节点经过的次数
            for (int[] trip : trips) {
                dfsPath(trip[0], trip[1], -1);
            }

            // 类似打家劫舍
            // 对每一个节点都判断前面的节点，是不是已经抢劫过
            int[] dfs = dfs(0, -1);
            return Math.min(dfs[0], dfs[1]);
        }

        /**
         * dfs 记录最短路径
         *
         * @param cur    当前节点
         * @param end    目标节点
         * @param father 当前节点的上一个节点，不走回头路
         * @return boolean
         */
        private boolean dfsPath(int cur, int end, int father) {
            if (cur == end) {
                total[cur]++;
                return true;
            }
            for (Integer next : graph[cur]) {
                if (next != father && dfsPath(next, end, cur)) {
                    // 这条路走通了
                    total[cur]++;
                    return true;
                }
            }

            return false;
        }

        private int[] dfs(int cur, int father) {
            // 每个节点都会走一次
            int notDis = price[cur] * total[cur];
            int dis = notDis / 2;
            for (Integer next : graph[cur]) {
                if (next == father) {
                    // 不走回头路，保证每一个节点只会走一次
                    continue;
                }
                int[] dfs = dfs(next, cur);
                // 当前选择不打折，前面可以打也可以不大
                notDis += Math.min(dfs[0], dfs[1]);
                // 当前打折，前面只能选不打折
                dis += dfs[0];
            }
            return new int[]{notDis, dis};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}