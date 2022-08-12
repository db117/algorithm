

//现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。 
//
// 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给
//你一个整数数组 restricted 表示 受限 节点。 
//
// 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。 
//
// 注意，节点 0 不 会标记为受限节点。 
//
// 
//
// 示例 1： 
// 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
//输出：4
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。 
//
// 示例 2： 
// 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
//
//输出：3
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵有效的树 
// 1 <= restricted.length < n 
// 1 <= restricted[i] < n 
// restricted 中的所有值 互不相同 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 数组 哈希表 👍 17 👎 0


package cn.db117.leetcode.solution23;

import java.util.*;

/**
 * 2368.受限条件下可到达节点的数目.reachable-nodes-with-restrictions
 *
 * @author db117
 * @since 2022-08-12 17:09:59
 **/

public class Solution_2368 {
    public static void main(String[] args) {
        Solution solution = new Solution_2368().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            int ans = 0;
            boolean[] hash = new boolean[n];

            Set<Integer> resSet = new HashSet<>();
            for (int i : restricted) {
                resSet.add(i);
            }

            // 邻接图
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                map.putIfAbsent(edge[0], new ArrayList<>());
                map.putIfAbsent(edge[1], new ArrayList<>());
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            // bfs
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer next = queue.poll();
                    hash[next] = true;
                    List<Integer> list = map.get(next);
                    if (list != null) {
                        for (Integer integer : list) {
                            if (!resSet.contains(integer) && !hash[integer]) {
                                queue.add(integer);
                            }
                        }
                    }
                }
            }

            for (boolean b : hash) {
                if (b) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}