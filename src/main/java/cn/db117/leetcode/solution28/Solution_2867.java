

//给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] =
// [ui, vi] 表示节点 ui 和 vi 在树中有一条边。 
//
// 请你返回树中的 合法路径数目 。 
//
// 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。 
//
// 注意： 
//
// 
// 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。 
// 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
//输出：4
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//只有 4 条合法路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
//输出：6
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//- (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
//只有 6 条合法路径。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 输入保证 edges 形成一棵合法的树。 
// 
//
// Related Topics 树 深度优先搜索 数学 动态规划 数论 👍 45 👎 0


package cn.db117.leetcode.solution28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2867.统计树中的合法路径数目.count-valid-paths-in-a-tree
 *
 * @author db117
 * @since 2024-02-27 14:43:45
 **/

public class Solution_2867 {
    public static void main(String[] args) {
        Solution solution = new Solution_2867().new Solution();
        // 5
        //			[[1,2],[1,3],[2,4],[2,5]]
        System.out.println(solution.countPaths(5, new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int mix = (int) 1e5;
        private final static int[] primes = new int[78500];

        // 标记是否是质数
        private final static boolean[] flag = new boolean[mix + 1];// 质数=false 非质数=true

        // 埃氏筛
        static {
            int pi = 0;
            flag[1] = true;
            for (int i = 2; i <= mix; ++i)
                if (!flag[i]) {
                    primes[pi++] = i;
                    // 避免溢出的写法
                    for (int j = i; j <= mix / i; ++j) {
                        flag[i * j] = true;
                    }
                }
            primes[pi++] = mix + 1;
            primes[pi++] = mix + 1; // 保证下面下标不会越界
        }

        public long countPaths(int n, int[][] edges) {
            long ans = 0;
            // 建图
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            Arrays.setAll(graph, i -> new ArrayList<>());
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            // 连在一块的非质数的数量
            int[] count = new int[n + 1];
            List<Integer> nodes = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (flag[i]) {
                    // 不是质数
                    continue;
                }
                int sum = 0;
                for (Integer next : graph[i]) {
                    if (!flag[next]) {
                        // 跳过质数
                        continue;
                    }

                    // 找再一块的非质数数量
                    if (count[next] == 0) {
                        // 没有计算过
                        nodes.clear();
                        // dfs 找到所有连在一块的非质数
                        dfs(next, -1, graph, nodes);
                        // 记录数量
                        nodes.forEach(node -> count[node] = nodes.size());
                    }

                    ans += (long) count[next] * sum;// 当前这批非质数乘以之前就找到的
                    sum += count[next];// 前面找到的所有非质数的数量
                }
                // 质数到非质数的数量
                ans += sum;
            }
            return ans;
        }

        private void dfs(int cur, int farther, ArrayList<Integer>[] graph, List<Integer> nodes) {
            nodes.add(cur);
            for (Integer next : graph[cur]) {
                if (next == farther) {
                    continue;
                }
                if (flag[next]) {
                    dfs(next, cur, graph, nodes);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}