

//有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 
//edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。 
//
// 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。 
//
// 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
//输出：true
//解释：存在由顶点 0 到顶点 2 的路径:
//- 0 → 1 → 2 
//- 0 → 2
// 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
//输出：false
//解释：不存在由顶点 0 到顶点 5 的路径.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 2 * 10⁵ 
// 0 <= edges.length <= 2 * 10⁵ 
// edges[i].length == 2 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= start, end <= n - 1 
// 不存在双向边 
// 不存在指向顶点自身的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 👍 36 👎 0


package cn.db117.leetcode.solution19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1971.寻找图中是否存在路径.find-if-path-exists-in-graph
 *
 * @author db117
 * @since 2022-06-15 16:24:39
 **/

public class Solution_1971 {
    public static void main(String[] args) {
        Solution solution = new Solution_1971().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            if (source == destination) {
                return true;
            }
            boolean[] flag = new boolean[n];
            // 构建图
            List<List<Integer>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            // 广度优先
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(graph.get(source));
            flag[source] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    flag[poll] = true;
                    // 到达目标节点
                    if (poll == destination) {
                        return true;
                    }

                    // 能够去到的所有节点
                    for (Integer next : graph.get(poll)) {
                        if (!flag[next]) {
                            // 没有访问过
                            queue.add(next);
                        }
                    }

                }
            }

            // 没有找到
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}