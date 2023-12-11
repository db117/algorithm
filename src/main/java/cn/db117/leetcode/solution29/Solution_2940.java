

//给你一个下标从 0 开始的正整数数组 heights ，其中 heights[i] 表示第 i 栋建筑的高度。 
//
// 如果一个人在建筑 i ，且存在 i < j 的建筑 j 满足 heights[i] < heights[j] ，那么这个人可以移动到建筑 j 。 
//
// 给你另外一个数组 queries ，其中 queries[i] = [ai, bi] 。第 i 个查询中，Alice 在建筑 ai ，Bob 在建筑 
//bi 。 
//
// 请你能返回一个数组 ans ，其中 ans[i] 是第 i 个查询中，Alice 和 Bob 可以相遇的 最左边的建筑 。如果对于查询 i ，Alice 
//和 Bob 不能相遇，令 ans[i] 为 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
//输出：[2,5,-1,5,2]
//解释：第一个查询中，Alice 和 Bob 可以移动到建筑 2 ，因为 heights[0] < heights[2] 且 heights[1] < 
//heights[2] 。
//第二个查询中，Alice 和 Bob 可以移动到建筑 5 ，因为 heights[0] < heights[5] 且 heights[3] < 
//heights[5] 。
//第三个查询中，Alice 无法与 Bob 相遇，因为 Alice 不能移动到任何其他建筑。
//第四个查询中，Alice 和 Bob 可以移动到建筑 5 ，因为 heights[3] < heights[5] 且 heights[4] < 
//heights[5] 。
//第五个查询中，Alice 和 Bob 已经在同一栋建筑中。
//对于 ans[i] != -1 ，ans[i] 是 Alice 和 Bob 可以相遇的建筑中最左边建筑的下标。
//对于 ans[i] == -1 ，不存在 Alice 和 Bob 可以相遇的建筑。
// 
//
// 示例 2： 
//
// 
//输入：heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
//输出：[7,6,-1,4,6]
//解释：第一个查询中，Alice 可以直接移动到 Bob 的建筑，因为 heights[0] < heights[7] 。
//第二个查询中，Alice 和 Bob 可以移动到建筑 6 ，因为 heights[3] < heights[6] 且 heights[5] < 
//heights[6] 。
//第三个查询中，Alice 无法与 Bob 相遇，因为 Bob 不能移动到任何其他建筑。
//第四个查询中，Alice 和 Bob 可以移动到建筑 4 ，因为 heights[3] < heights[4] 且 heights[0] < 
//heights[4] 。
//第五个查询中，Alice 可以直接移动到 Bob 的建筑，因为 heights[1] < heights[6] 。
//对于 ans[i] != -1 ，ans[i] 是 Alice 和 Bob 可以相遇的建筑中最左边建筑的下标。
//对于 ans[i] == -1 ，不存在 Alice 和 Bob 可以相遇的建筑。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <= 5 * 10⁴ 
// 1 <= heights[i] <= 10⁹ 
// 1 <= queries.length <= 5 * 10⁴ 
// queries[i] = [ai, bi] 
// 0 <= ai, bi <= heights.length - 1 
// 
//
// Related Topics 栈 树状数组 线段树 数组 二分查找 单调栈 堆（优先队列） 👍 15 👎 0


package cn.db117.leetcode.solution29;

import java.util.*;

/**
 * 2940.找到 Alice 和 Bob 可以相遇的建筑.find-building-where-alice-and-bob-can-meet
 *
 * @author db117
 * @since 2023-11-28 10:23:41
 **/

public class Solution_2940 {
    public static void main(String[] args) {
        Solution solution = new Solution_2940().new Solution();
        // [1,2,1,2,1,2]
        //			[[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[1,0],[1,1],[1,2],[1,3],[1,4],[1,5],[2,0],[2,1],[2,2],[2,3],[2,4],[2,5],[3,0],[3,1],[3,2],[3,3],[3,4],[3,5],[4,0],[4,1],[4,2],[4,3],[4,4],[4,5],[5,0],[5,1],[5,2],[5,3],[5,4],[5,5]]
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(new int[]{
                1, 2, 1, 2, 1, 2
        }, new int[][]{
                {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
                {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5},
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5},
                {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5},
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5},
                {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}
        })));
        // [0,1,3,3,5,5,1,1,-1,-1,-1,-1,3,-1,2,3,5,5,3,-1,3,3,-1,-1,5,-1,5,-1,4,5,5,-1,5,-1,5,5]
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            int n = queries.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            // 离线查询

            // 记录需要加入堆的位置
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                // 调整查询位置的顺序,保证i<j
                if (query[0] > query[1]) {
                    int tmp = query[0];
                    query[0] = query[1];
                    query[1] = tmp;
                }

                if (heights[query[0]] < heights[query[1]] || query[0] == query[1]) {
                    // 左边的比右边的小,直接跳
                    ans[i] = query[1];
                } else {
                    map.computeIfAbsent(query[1], k -> new ArrayList<>()).add(new int[]{heights[query[0]], i});
                }
            }

            // 从小到大排序,每次弹出来的就是左边能到达的第一个大于的
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < heights.length; i++) {
                // 弹出小于当前位置的
                while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                    // 弹出的位置就是左边能到达的第一个大于的位置
                    int[] poll = pq.poll();
                    ans[poll[1]] = i;
                }


                // 加入堆
                // 当前位置的高度,和需要加入堆的位置
                List<int[]> list = map.get(i);
                if (list != null) {
                    for (int[] ints : list) {
                        pq.offer(ints);
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}