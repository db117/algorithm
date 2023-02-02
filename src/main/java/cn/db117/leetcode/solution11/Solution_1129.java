

//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 156 👎 0


package cn.db117.leetcode.solution11;

import java.util.*;

/**
 * 1129.颜色交替的最短路径.shortest-path-with-alternating-colors
 *
 * @author db117
 * @since 2023-02-02 10:13:58
 **/

public class Solution_1129 {
    public static void main(String[] args) {
        Solution solution = new Solution_1129().new Solution();
        // 5
        // redEdges =
        //[[0,1],[1,2],[2,3],[3,4]]
        //blueEdges =
        //[[1,2],[2,3],[3,1]]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                new int[][]{{1, 2}, {2, 3}, {3, 1}})));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int[] ans = new int[n];
            Map<Integer, Set<Integer>> redMap = new HashMap<>();
            Map<Integer, Set<Integer>> blueMap = new HashMap<>();
            Set<Integer> path = new HashSet<>();
            Arrays.fill(ans, -1);
            ans[0] = 0;

            for (int[] redEdge : redEdges) {
                redMap.putIfAbsent(redEdge[0], new HashSet<>());
                redMap.get(redEdge[0]).add(redEdge[1]);
            }

            for (int[] blueEdge : blueEdges) {
                blueMap.putIfAbsent(blueEdge[0], new HashSet<>());
                blueMap.get(blueEdge[0]).add(blueEdge[1]);
            }

            // 蓝色为负
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(redMap.getOrDefault(0, Collections.emptySet()));
            if (blueMap.containsKey(0)) {
                for (Integer integer : blueMap.get(0)) {
                    queue.add(-integer);
                }
            }
            int step = 0;
            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer cur = queue.poll();
                    if (!path.add(cur)) {
                        // 访问过
                        continue;
                    }
                    int index = Math.abs(cur);
                    if (ans[index] == -1) {
                        // 第一次访问
                        ans[index] = step;
                    }

                    if (cur > 0) {
                        // red
                        if (blueMap.containsKey(cur)) {
                            for (Integer b : blueMap.get(cur)) {
                                queue.add(-b);
                            }
                        }
                    } else {
                        // blue
                        queue.addAll(redMap.getOrDefault(index, Collections.emptySet()));
                    }
                }
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}