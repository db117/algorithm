

//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
//部决定重新规划路线，以改变交通拥堵的状况。 
//
// 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。 
//
// 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。 
//
// 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。 
//
// 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//输出：3
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。 
//
// 示例 2： 
//
// 
//
// 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//输出：2
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。 
//
// 示例 3： 
//
// 输入：n = 3, connections = [[1,0],[2,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 5 * 10^4 
// connections.length == n-1 
// connections[i].length == 2 
// 0 <= connections[i][0], connections[i][1] <= n-1 
// connections[i][0] != connections[i][1] 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 199 👎 0


package cn.db117.leetcode.solution14;

import java.util.*;

/**
 * 1466.重新规划路线.reorder-routes-to-make-all-paths-lead-to-the-city-zero
 *
 * @author db117
 * @since 2023-12-07 17:30:26
 **/

public class Solution_1466 {
    public static void main(String[] args) {
        Solution solution = new Solution_1466().new Solution();
        // 3
        //			[[1,0],[2,0]]
//        System.out.println(solution.minReorder(3, new int[][]{
//                {1, 0}, {2, 0}
//        }));

        // 4
        //			[[0,1],[2,0],[3,2]]
        System.out.println(solution.minReorder(4, new int[][]{
                {0, 1}, {2, 0}, {3, 2}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minReorder(int n, int[][] connections) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] connection : connections) {
                map.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
                map.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(-connection[0]);// 负数表示反向
            }
            int ans = 0;
            // 从 0 开始走,方向为正则需要改方向
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            Set<Integer> set = new HashSet<>();
            set.add(0);
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                List<Integer> list = map.get(cur);
                if (list != null) {
                    for (Integer i : list) {
                        if (!set.add(Math.abs(i))) {
                            continue;
                        }
                        if (i < 0) {
                            queue.offer(-i);
                        } else {
                            // 是从 0 开始往外走的
                            ans++;
                            queue.offer(i);
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}