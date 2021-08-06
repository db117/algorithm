// 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
//
// 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。 
//
// 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,2,3],[0],[0],[0]]
//输出：4
//解释：一种可能的路径为 [1,0,2,0,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
//输出：4
//解释：一种可能的路径为 [0,1,4,2,3]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 12 
// 0 <= graph[i].length < n 
// graph[i] 不包含 i 
// 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a 
// 输入的图总是连通图 
// 
// Related Topics 位运算 广度优先搜索 图 动态规划 状态压缩 
// 👍 168 👎 0


package cn.db117.leetcode.solution8;

import java.util.*;

/**
 * 847.访问所有节点的最短路径.shortest-path-visiting-all-nodes
 *
 * @author db117
 * @since 2021-08-06 11:11:08
 **/

public class Solution_847 {
    public static void main(String[] args) {
        Solution solution = new Solution_847().new Solution();

        System.out.println(solution.shortestPathLength(new int[][]{
                {1, 2, 3}, {0}, {0}, {0}
        }));
        System.out.println(solution.shortestPathLength(new int[][]{
                {1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}
        }));
        System.out.println(solution.shortestPathLength(new int[][]{
                {2, 3, 5, 7}, {2, 3, 7}, {0, 1}, {0, 1}, {7}, {0}, {10}, {9, 10, 0, 1, 4}, {9}, {7, 8}, {7, 6}
        }));
        System.out.println(solution.shortestPathLength(new int[][]{
                {}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            int mark = (1 << n) - 1;

            // 图节点  状态标记 步数
            Queue<int[]> queue = new LinkedList<>();
            // 保存以每一个节点开始的状态
            List<Set<Integer>> states = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                queue.offer(new int[]{i, 1 << i, 0});

                states.add(new HashSet<>());
                states.get(i).add(1 << i);
            }

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int index = poll[0], flag = poll[1], step = poll[2];

                for (int i : graph[index]) {
                    // 走到当前位置的状态
                    int curFlag = flag | 1 << i;
                    if (!states.get(i).add(curFlag)) {
                        // 以 i 节点开始是已经出现过当前状态
                        continue;
                    }
                    if (curFlag == mark) {
                        // 全部走完了
                        return step + 1;
                    }

                    queue.offer(new int[]{i, curFlag, step + 1});
                }
            }

            // 就一个节点
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}