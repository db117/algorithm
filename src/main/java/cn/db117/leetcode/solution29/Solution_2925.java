

//有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 
//edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。 
//
// 同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。 
//
// 一开始你的分数为 0 ，每次操作中，你将执行： 
//
// 
// 选择节点 i 。 
// 将 values[i] 加入你的分数。 
// 将 values[i] 变为 0 。 
// 
//
// 如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。 
//
// 你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]
//输出：11
//解释：我们可以选择节点 1 ，2 ，3 ，4 和 5 。根节点的值是非 0 的。所以从根出发到任意叶子节点路径上节点值之和都不为 0 。所以树是健康的。你的
//得分之和为 values[1] + values[2] + values[3] + values[4] + values[5] = 11 。
//11 是你对树执行任意次操作以后可以获得的最大得分之和。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [20,10,9,7,4,3,5]
//输出：40
//解释：我们选择节点 0 ，2 ，3 和 4 。
//- 从 0 到 4 的节点值之和为 10 。
//- 从 0 到 3 的节点值之和为 10 。
//- 从 0 到 5 的节点值之和为 3 。
//- 从 0 到 6 的节点值之和为 5 。
//所以树是健康的。你的得分之和为 values[0] + values[2] + values[3] + values[4] = 40 。
//40 是你对树执行任意次操作以后可以获得的最大得分之和。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// values.length == n 
// 1 <= values[i] <= 10⁹ 
// 输入保证 edges 构成一棵合法的树。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 👍 20 👎 0


package cn.db117.leetcode.solution29;

import java.util.*;

/**
 * 2925.在树上执行操作以后得到的最大分数.maximum-score-after-applying-operations-on-a-tree
 *
 * @author db117
 * @since 2023-11-15 17:05:05
 **/

public class Solution_2925 {
    public static void main(String[] args) {
        Solution solution = new Solution_2925().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] values;
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[][] memo = new long[20002][2];

        public long maximumScoreAfterOperations(int[][] edges, int[] values) {
            this.values = values;
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            for (long[] longs : memo) {
                Arrays.fill(longs, -1);
            }
            // 当前节点选择留不留
            long not = values[0];
            // 当前节点选择留
            long yes = 0;
            for (Integer i : map.get(0)) {
                not += dfs(i, 0, 0);
                yes += dfs(i, 1, 0);
            }
            return Math.max(not, yes);
        }

        /**
         * @param flag   当前链路是否已经有不为 0 的数字了
         * @param parent 父节点
         */
        private long dfs(int index, int flag, int parent) {
            if (memo[index][flag] != -1) {
                return memo[index][flag];
            }
            List<Integer> list = map.get(index);
            if (list.size() == 1 && list.get(0) == parent) {
                // 叶子节点
                if (flag == 1) {
                    // 选择
                    return values[index];
                } else {
                    // 不选择(前面都选择,最后一个必须留着)
                    return 0;
                }
            }
            long ans;
            if (flag == 1) {
                // 上面有留下的,后面全都可以选择
                ans = values[index];
                for (Integer i : list) {
                    if (i != parent) {
                        ans += dfs(i, 1, index);
                    }
                }
            } else {
                ans = 0;
                // 当前节点选择留不留
                long not = values[index];
                // 当前节点选择留
                long yes = 0;
                for (Integer i : list) {
                    if (i != parent) {
                        not += dfs(i, 0, index);
                        yes += dfs(i, 1, index);
                    }
                }
                ans = Math.max(not, yes);
            }
            return memo[index][flag] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}