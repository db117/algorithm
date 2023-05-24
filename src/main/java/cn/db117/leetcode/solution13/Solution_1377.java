

//给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下： 
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 74 👎 0


package cn.db117.leetcode.solution13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1377.T 秒后青蛙的位置.frog-position-after-t-seconds
 *
 * @author db117
 * @since 2023-05-24 11:04:36
 **/

public class Solution_1377 {
    public static void main(String[] args) {
        Solution solution = new Solution_1377().new Solution();
        // n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
        System.out.println(solution.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 2, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                map.putIfAbsent(edge[0], new HashSet<>());
                map.putIfAbsent(edge[1], new HashSet<>());
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }
            // 添加一个假节点 0
            map.put(0, new HashSet<>());
            map.putIfAbsent(1, new HashSet<>());
            map.get(0).add(1);
            map.get(1).add(0);

            // 都是 1/2 这种相乘，直接把分母相乘完事
            long dfs = dfs(map, target, 0, 1, t);

            return dfs == 0 ? 0 : 1.0 / dfs;
        }

        private long dfs(Map<Integer, Set<Integer>> map, int target, int fa, int x, int remain) {
            if (remain == 0) {
                // 步数走完了
                return target == x ? 1 : 0;
            }
            if (x == target) {
                // 都到目标了，如果当前节点没有子节点，那么会一直留在这  否则不会在回来了
                return map.get(x).size() == 1 ? 1 : 0;
            }

            for (Integer next : map.get(x)) {
                if (next != fa) {
                    // 一步步走
                    long dfs = dfs(map, target, x, next, remain - 1);
                    if (dfs != 0) {
                        // 能走到目的地
                        return dfs * (map.get(x).size() - 1);// 当前节点能去到的节点数量
                    }
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}