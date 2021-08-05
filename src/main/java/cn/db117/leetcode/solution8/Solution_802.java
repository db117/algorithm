// 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
//
// 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。 
//
// 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 104 
// 0 <= graph[i].length <= n 
// graph[i] 按严格递增顺序排列。 
// 图中可能包含自环。 
// 图中边的数目在范围 [1, 4 * 104] 内。 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 181 👎 0


package cn.db117.leetcode.solution8;

import java.util.*;

/**
 * 802.找到最终的安全状态.find-eventual-safe-states
 *
 * @author db117
 * @since 2021-08-05 10:27:10
 **/

public class Solution_802 {
    public static void main(String[] args) {
        Solution solution = new Solution_802().new Solution();
        System.out.println(solution.eventualSafeNodes(new int[][]{
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        }));
        System.out.println(solution.eventualSafeNodes(new int[][]{
                {1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            // 记录出度
            int[] to = new int[graph.length];
            // 记录入度
            Map<Integer, List<Integer>> from = new HashMap<>();


            // 记录出度 入度
            for (int i = 0; i < graph.length; i++) {
                // 出度
                to[i] = graph[i].length;
                // 入度
                for (int j = 0; j < graph[i].length; j++) {
                    int k = graph[i][j];
                    if (!from.containsKey(k)) {
                        from.put(k, new ArrayList<>());
                    }

                    from.get(k).add(i);
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < to.length; i++) {
                if (to[i] == 0) {
                    // 添加出度为 0 的，开始就为安全节点
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                // 所有指向安全节点的节点都 可能 为安全节点
                List<Integer> list = from.get(poll);
                if (list == null) {
                    continue;
                }
                for (Integer formI : list) {
                    to[formI]--;
                    // 当前节点都指向为安全节点，则为安全节点
                    if (to[formI] == 0) {
                        queue.offer(formI);
                    }
                }
            }

            // 所有出度为 0 的节点都是安全节点
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < to.length; i++) {
                if (to[i] == 0) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}