

//给你两棵 无向 树，分别有 n 和 m 个节点，节点编号分别为 0 到 n - 1 和 0 到 m - 1 。给你两个二维整数数组 edges1 和 
//edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示在第一棵树中节点 ai 和 bi 之间有一条边，
//edges2[i] = [ui, vi] 表示在第二棵树中节点 ui 和 vi 之间有一条边。 
//
// 你必须在第一棵树和第二棵树中分别选一个节点，并用一条边连接它们。 
//
// 请你返回添加边后得到的树中，最小直径 为多少。 
//
// 一棵树的 直径 指的是树中任意两个节点之间的最长路径长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入：edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 将第一棵树中的节点 0 与第二棵树中的任意节点连接，得到一棵直径为 3 得树。 
//
// 示例 2： 
//
// 
// 输入：edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2
//],[0,3],[2,4],[2,5],[3,6],[2,7]] 
// 
//
// 输出：5 
//
// 解释： 
//
// 将第一棵树中的节点 0 和第二棵树中的节点 0 连接，可以得到一棵直径为 5 的树。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 10⁵ 
// edges1.length == n - 1 
// edges2.length == m - 1 
// edges1[i].length == edges2[i].length == 2 
// edges1[i] = [ai, bi] 
// 0 <= ai, bi < n 
// edges2[i] = [ui, vi] 
// 0 <= ui, vi < m 
// 输入保证 edges1 和 edges2 分别表示一棵合法的树。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 6 👎 0


package cn.db117.leetcode.solution32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3203.合并两棵树后的最小直径.find-minimum-diameter-after-merging-two-trees
 *
 * @author db117
 * @since 2024-07-04 11:24:02
 **/

public class Solution_3203 {
    public static void main(String[] args) {
        Solution solution = new Solution_3203().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            // 记录两棵树的直径
            // 在直径中间连接
            treeDiameter(edges1);
            int max1 = (max + 1) / 2;
            int maxTemp = max;
            max = 0;
            treeDiameter(edges2);
            int max2 = (max + 1) / 2;
            int join = max1 + max2 + 1;
            return Math.max(maxTemp, Math.max(max, join));
        }


        int max = 0;

        public int treeDiameter(int[][] edges) {
            if (edges.length == 0) {
                return 0;
            }
            Map<Integer, List<Integer>> edge = new HashMap<>();
            for (int[] ints : edges) {
                edge.putIfAbsent(ints[0], new ArrayList<>());
                edge.putIfAbsent(ints[1], new ArrayList<>());

                edge.get(ints[0]).add(ints[1]);
                edge.get(ints[1]).add(ints[0]);
            }

            // 从任意一个点开始找最长的路径
            dfs(edge, -1, 0);

            return max;
        }

        private int dfs(Map<Integer, List<Integer>> edge, int pre, int cur) {
            // 最长路径
            int maxLen = 0;
            for (Integer next : edge.get(cur)) {
                if (pre == next) {
                    continue;
                }
                // 第二长路径
                int subLen = dfs(edge, cur, next) + 1;
                max = Math.max(max, subLen + maxLen);
                maxLen = Math.max(maxLen, subLen);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}