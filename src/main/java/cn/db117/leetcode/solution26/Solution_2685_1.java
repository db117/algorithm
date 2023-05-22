

//给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = 
//[ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。 
//
// 返回图中 完全连通分量 的数量。 
//
// 如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。 
//
// 如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
//输出：3
//解释：如上图所示，可以看到此图所有分量都是完全连通分量。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
//输出：1
//解释：包含节点 0、1 和 2 的分量是完全连通分量，因为每对节点之间都存在一条边。
//包含节点 3 、4 和 5 的分量不是完全连通分量，因为节点 4 和 5 之间不存在边。
//因此，在图中完全连接分量的数量是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 0 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 不存在重复的边 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 13 👎 0


package cn.db117.leetcode.solution26;

import java.util.*;

/**
 * 2685.统计完全连通分量的数量.count-the-number-of-complete-components
 *
 * @author db117
 * @since 2023-05-22 11:04:07
 **/

public class Solution_2685_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_2685_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int v, e;
        Map<Integer, Set<Integer>> eMap = new HashMap<>();
        boolean[] visit;

        public int countCompleteComponents(int n, int[][] edges) {
            // DFS 每个连通块，统计当前连通块的点数 v 和边数 e。
            //每访问一个点，就把 v 加一。
            //e 加上点 v 的邻居个数。注意这样一条边会统计两次。
            // e=v(v-1)

            // 通过 dfs 可以对每一个连通块进行遍历，记录变数和点数
            visit = new boolean[n];
            // 建图
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                eMap.putIfAbsent(x, new HashSet<>());
                eMap.putIfAbsent(y, new HashSet<>());

                eMap.get(x).add(y);
                eMap.get(y).add(x);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    // 一次可以走一个连通块
                    e = 0;
                    v = 0;
                    dfs(i);// 记录边数，点数
                    if (e == v * (v - 1)) {// 校验
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int i) {
            visit[i] = true;
            v++;
            Set<Integer> set = eMap.getOrDefault(i, Collections.emptySet());
            for (Integer next : set) {
                e++;// 记录边数
                if (!visit[next]) {
                    // 下一个节点继续走
                    dfs(next);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}