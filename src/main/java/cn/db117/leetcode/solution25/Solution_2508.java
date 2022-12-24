

//给你一个有 n 个节点的 无向 图，节点编号为 1 到 n 。再给你整数 n 和一个二维整数数组 edges ，其中 edges[i] = [ai, bi]
// 表示节点 ai 和 bi 之间有一条边。图不一定连通。 
//
// 你可以给图中添加 至多 两条额外的边（也可以一条边都不添加），使得图中没有重边也没有自环。 
//
// 如果添加额外的边后，可以使得图中所有点的度数都是偶数，返回 true ，否则返回 false 。 
//
// 点的度数是连接一个点的边的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]
//输出：true
//解释：上图展示了添加一条边的合法方案。
//最终图中每个节点都连接偶数条边。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 4, edges = [[1,2],[3,4]]
//输出：true
//解释：上图展示了添加两条边的合法方案。 
//
// 示例 3： 
//
// 
//
// 
//输入：n = 4, edges = [[1,2],[1,3],[1,4]]
//输出：false
//解释：无法添加至多 2 条边得到一个符合要求的图。 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// 2 <= edges.length <= 10⁵ 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// ai != bi 
// 图中不会有重边 
// 
//
// 👍 10 👎 0


package cn.db117.leetcode.solution25;

import java.util.*;

/**
 * 2508.添加边使所有节点度数都为偶数.add-edges-to-make-degrees-of-all-nodes-even
 *
 * @author db117
 * @since 2022-12-19 11:12:05
 **/
@SuppressWarnings("unchecked")
public class Solution_2508 {
    public static void main(String[] args) {

        Solution solution = new Solution_2508().new Solution();
        // 4
        // [[1,2],[2,3],[2,4],[3,4]]
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1, 2));
        lists.add(List.of(2, 3));
        lists.add(List.of(2, 4));
        lists.add(List.of(3, 4));
        System.out.println(solution.isPossible(4, lists));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int n, List<List<Integer>> edges) {
            // 建图
            var graph = new HashSet[n + 1];
            Arrays.setAll(graph, value -> new HashSet<>());
            for (List<Integer> edge : edges) {
                graph[edge.get(0)].add(edge.get(1));
                graph[edge.get(1)].add(edge.get(0));
            }
            // 奇数条边
            var odd = new ArrayList<Integer>();
            for (int i = 0, graphLength = graph.length; i < graphLength; i++) {
                var hashSet = graph[i];
                if ((hashSet.size() & 1) == 1) {
                    odd.add(i);
                }
            }
            // 符合题意
            if (odd.size() == 0) {
                return true;
            }

            if (odd.size() == 2) {
                var a = odd.get(0);
                var b = odd.get(1);
                if (!graph[a].contains(b)) {
                    // 刚好能够凑成
                    return true;
                }
                for (int i = 1; i <= n; i++) {
                    // 有任意一个点,可以同时和 a b 连线
                    if (i != a && i != b && !graph[a].contains(i) && !graph[b].contains(i)) {
                        return true;
                    }
                }
            }
            if (odd.size() == 4) {
                var a = odd.get(0);
                var b = odd.get(1);
                var c = odd.get(2);
                var d = odd.get(3);
                // 刚好凑成两队
                if (!graph[a].contains(b) && !graph[c].contains(d)) {
                    return true;
                }
                if (!graph[a].contains(c) && !graph[b].contains(d)) {
                    return true;
                }
                if (!graph[a].contains(d) && !graph[c].contains(b)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}