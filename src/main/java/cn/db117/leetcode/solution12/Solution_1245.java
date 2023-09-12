

//给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。 
//
// 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。 
//
// 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：edges = [[0,1],[0,2]]
//输出：2
//解释：
//这棵树上最长的路径是 1 - 0 - 2，边数为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
//输出：4
//解释： 
//这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= edges.length < 10^4 
// edges[i][0] != edges[i][1] 
// 0 <= edges[i][j] <= edges.length 
// edges 会形成一棵无向树 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 拓扑排序 👍 103 👎 0


package cn.db117.leetcode.solution12;

import java.util.*;

/**
 * 1245.树的直径.tree-diameter
 *
 * @author db117
 * @since 2023-06-08 10:44:06
 **/

public class Solution_1245 {
    public static void main(String[] args) {
        Solution solution = new Solution_1245().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int treeDiameter(int[][] edges) {
            if (edges.length == 0) {
                return 0;
            }
            Map<Integer, Set<Integer>> edge = new HashMap<>();
            for (int[] ints : edges) {
                edge.putIfAbsent(ints[0], new HashSet<>());
                edge.putIfAbsent(ints[1], new HashSet<>());

                edge.get(ints[0]).add(ints[1]);
                edge.get(ints[1]).add(ints[0]);
            }

            // 从任意一个点开始找最长的路径
            dfs(edge, -1, 0);

            return ans;
        }

        private int dfs(Map<Integer, Set<Integer>> edge, int pre, int cur) {
            List<Integer> list = new ArrayList<>(edge.get(cur).size());
            for (Integer next : edge.get(cur)) {
                if (pre == next) {
                    continue;
                }
                list.add(dfs(edge, cur, next) + 1);
            }
            list.sort(Comparator.reverseOrder());
            // 找到最长的两条路径
            if (list.size() >= 2) {
                ans = Math.max(ans, list.get(0) + list.get(1));
            } else if (list.size() == 1) {
                ans = Math.max(ans, list.get(0));
            }

            return list.isEmpty() ? 0 : list.get(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}