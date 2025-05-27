

//给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。 
//
// 给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。同时给你一个二维数组 
//edges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。 
//
// 图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图
//中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。 
//
// 请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
//输出：3
//解释：路径 0 -> 2 -> 3 -> 4 含有 3 个颜色为 "a" 的节点（上图中的红色节点）。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：colors = "a", edges = [[0,0]]
//输出：-1
//解释：从 0 到 0 有一个环。
// 
//
// 
//
// 提示： 
//
// 
// n == colors.length 
// m == edges.length 
// 1 <= n <= 10⁵ 
// 0 <= m <= 10⁵ 
// colors 只含有小写英文字母。 
// 0 <= aj, bj < n 
// 
//
// Related Topics 图 拓扑排序 记忆化搜索 哈希表 动态规划 计数 👍 97 👎 0


package cn.db117.leetcode.solution18;

import java.util.ArrayList;
import java.util.List;

/**
 * 1857.有向图中最大颜色值.largest-color-value-in-a-directed-graph
 *
 * @author db117
 * @since 2025-05-26 18:46:58
 **/

public class Solution_1857 {
    public static void main(String[] args) {
        Solution solution = new Solution_1857().new Solution();
        // "abaca"
        //			[[0,1],[0,2],[2,3],[3,4]]
        System.out.println(solution.largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] graph;
        int[][] memo;
        String colors;
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            graph = new List[n];
            memo = new int[n][];
            this.colors = colors;
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                if (edge[1] == edge[0]) {
                    // 存在环
                    return -1;
                }
                graph[edge[0]].add(edge[1]);
            }

            int ans = 0;
            int[] color = new int[n];
            for (int i = 0; i < graph.length; i++) {
                if (color[i] == 0 && cycleDfs(color, i)) {
                    //  存在环
                    return -1;
                }
                // 获取最大颜色值
                int[] dfs = dfs(i);
                for (int j = 0; j < 26; j++) {
                    ans = Math.max(ans, dfs[j]);
                }
            }


            return ans;
        }

        int[] dfs(int cur) {
            if (memo[cur] != null) {
                return memo[cur];
            }
            int[] res = new int[26];
            for (Integer i : graph[cur]) {
                int[] next = dfs(i);
                for (int j = 0; j < 26; j++) {
                    res[j] = Math.max(res[j], next[j]);
                }
            }
            // 当前节点颜色
            res[colors.charAt(cur) - 'a']++;

            return memo[cur] = res;
        }

        // 三色法判断是否存在环
        boolean cycleDfs(int[] color, int cur) {
            color[cur] = 1;// 访问中
            for (Integer next : graph[cur]) {
                if (color[next] == 1 || (color[next] == 0 && cycleDfs(color, next))) {
                    // 存在环
                    return true;
                }
            }
            color[cur] = 2;// 访问完成
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}