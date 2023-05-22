

//给你一个数组 start ，其中 start = [startX, startY] 表示你的初始位置位于二维空间上的 (startX, startY) 。另
//给你一个数组 target ，其中 target = [targetX, targetY] 表示你的目标位置 (targetX, targetY) 。 
//
// 从位置 (x1, y1) 到空间中任一其他位置 (x2, y2) 的代价是 |x2 - x1| + |y2 - y1| 。 
//
// 给你一个二维数组 specialRoads ，表示空间中存在的一些特殊路径。其中 specialRoads[i] = [x1i, y1i, x2i, y2
//i, costi] 表示第 i 条特殊路径可以从 (x1i, y1i) 到 (x2i, y2i) ，但成本等于 costi 。你可以使用每条特殊路径任意次数。 
//
//
// 返回从 (startX, startY) 到 (targetX, targetY) 所需的最小代价。 
//
// 
//
// 示例 1： 
//
// 输入：start = [1,1], target = [4,5], specialRoads = [[1,2,3,3,2],[3,4,4,5,1]]
//输出：5
//解释：从 (1,1) 到 (4,5) 的最优路径如下：
//- (1,1) -> (1,2) ，移动的代价是 |1 - 1| + |2 - 1| = 1 。
//- (1,2) -> (3,3) ，移动使用第一条特殊路径，代价是 2 。
//- (3,3) -> (3,4) ，移动的代价是 |3 - 3| + |4 - 3| = 1.
//- (3,4) -> (4,5) ，移动使用第二条特殊路径，代价是 1 。
//总代价是 1 + 2 + 1 + 1 = 5 。
//可以证明无法以小于 5 的代价完成从 (1,1) 到 (4,5) 。
// 
//
// 示例 2： 
//
// 输入：start = [3,2], target = [5,7], specialRoads = [[3,2,3,4,4],[3,3,5,5,5],[3,
//4,5,6,6]]
//输出：7
//解释：最优路径是不使用任何特殊路径，直接以 |5 - 3| + |7 - 2| = 7 的代价从初始位置到达目标位置。
// 
//
// 
//
// 提示： 
//
// 
// start.length == target.length == 2 
// 1 <= startX <= targetX <= 10⁵ 
// 1 <= startY <= targetY <= 10⁵ 
// 1 <= specialRoads.length <= 200 
// specialRoads[i].length == 5 
// startX <= x1i, x2i <= targetX 
// startY <= y1i, y2i <= targetY 
// 1 <= costi <= 10⁵ 
// 
//
// Related Topics 图 数组 最短路 堆（优先队列） 👍 25 👎 0


package cn.db117.leetcode.solution26;

import java.util.*;

/**
 * 2662.前往目标的最小代价.minimum-cost-of-a-path-with-special-roads
 *
 * @author db117
 * @since 2023-05-22 10:22:55
 **/

public class Solution_2662 {
    public static void main(String[] args) {
        Solution solution = new Solution_2662().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
            int min = Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);

            // 代价-》位置
            Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(value -> value[0]));

            long end = helper(target[0], target[1]);

            Set<Long> set = new HashSet<>();
            queue.add(new long[]{0, helper(start[0], start[1])});

            while (!queue.isEmpty()) {
                long[] poll = queue.poll();
                if (!set.add(poll[1])) {
                    continue;
                }
                int[] curIndex = helper1(poll[1]);
                if (poll[1] == end) {
                    min = (int) Math.min(min, poll[0]);
                }

                // 直接找特殊位置的就行
                for (int[] specialRoad : specialRoads) {
                    // 从 poll 到当前特殊位置的值
                    int cur = (int) (Math.abs(curIndex[0] - specialRoad[0]) + Math.abs(curIndex[1] - specialRoad[1]) + specialRoad[4] + poll[0]);
                    if (cur < min) {
                        long next = helper(specialRoad[2], specialRoad[3]);

                        queue.add(new long[]{cur, next});

                    }
                }

                int cur = (int) (Math.abs(curIndex[0] - target[0]) + Math.abs(curIndex[1] - target[1]) + poll[0]);
                if (cur < min) {
                    queue.add(new long[]{cur, end});
                }
            }
            return min;
        }

        private long helper(int x, int y) {
            return (long) x * Integer.MAX_VALUE + y;
        }

        private int[] helper1(long l) {
            return new int[]{(int) (l / Integer.MAX_VALUE), (int) (l % Integer.MAX_VALUE)};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}