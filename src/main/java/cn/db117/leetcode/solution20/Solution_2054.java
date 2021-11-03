

//给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。第 
//i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。你 最多 可以参加 两个时间不重叠 
//活动，使得它们的价值之和 最大 。 
//
// 请你返回价值之和的 最大值 。 
//
// 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。更具体的，如果你参加一个
//活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：events = [[1,3,2],[4,5,2],[2,4,3]]
//输出：4
//解释：选择绿色的活动 0 和 1 ，价值之和为 2 + 2 = 4 。
// 
//
// 示例 2： 
//
// 
//
// 输入：events = [[1,3,2],[4,5,2],[1,5,5]]
//输出：5
//解释：选择活动 2 ，价值和为 5 。
// 
//
// 示例 3： 
//
// 
//
// 输入：events = [[1,5,3],[1,5,1],[6,6,5]]
//输出：8
//解释：选择活动 0 和 2 ，价值之和为 3 + 5 = 8 。 
//
// 
//
// 提示： 
//
// 
// 2 <= events.length <= 10⁵ 
// events[i].length == 3 
// 1 <= startTimei <= endTimei <= 10⁹ 
// 1 <= valuei <= 10⁶ 
// 
// 👍 9 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2054.两个最好的不重叠活动.two-best-non-overlapping-events
 *
 * @author db117
 * @since 2021-11-02 16:36:12
 **/

public class Solution_2054 {
    public static void main(String[] args) {
        Solution solution = new Solution_2054().new Solution();
        System.out.println(solution.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}));
        System.out.println(solution.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {1, 5, 5}}));
        System.out.println(solution.maxTwoEvents(new int[][]{{1, 5, 3}, {1, 5, 1}, {6, 6, 5}}));
        // 199
        System.out.println(solution.maxTwoEvents(new int[][]{{90, 97, 78}, {80, 94, 55}, {2, 51, 48}, {8, 60, 27},
                {17, 78, 63}, {61, 86, 67}, {10, 52, 39}, {44, 77, 94}, {2, 27, 28}, {23, 29, 60}, {51, 88, 80},
                {56, 60, 8}, {93, 99, 94}, {83, 90, 73}, {17, 99, 83}, {40, 61, 88}, {65, 100, 29}, {10, 43, 21},
                {68, 82, 14}, {30, 41, 75}, {40, 63, 11}, {93, 94, 50}, {27, 75, 35}, {38, 82, 61}, {76, 78, 17},
                {42, 44, 31}, {55, 84, 4}, {89, 89, 59}, {14, 38, 18}, {82, 89, 4}, {92, 98, 46}, {2, 6, 25},
                {100, 100, 24}, {12, 64, 47}, {29, 44, 41}, {84, 84, 84}, {62, 82, 45}, {55, 99, 38}, {72, 85, 75},
                {82, 83, 30}, {54, 95, 75}, {87, 92, 33}, {52, 78, 86}, {28, 81, 42}, {89, 96, 100}, {97, 97, 35},
                {99, 99, 44}, {13, 18, 95}, {51, 68, 91}, {55, 77, 12}, {13, 40, 12}, {78, 78, 4}, {22, 59, 96},
                {82, 99, 26}, {15, 64, 80}, {15, 25, 34}, {86, 96, 53}, {95, 98, 71}, {84, 90, 81}, {39, 84, 97},
                {69, 92, 66}, {95, 100, 31}, {76, 81, 95}, {92, 94, 43}, {6, 66, 12}, {39, 91, 75}, {59, 94, 89},
                {35, 94, 40}, {93, 94, 8}, {73, 89, 96}, {2, 46, 53}, {26, 32, 51}, {41, 84, 77}, {56, 70, 12},
                {25, 76, 16}, {75, 90, 27}, {98, 98, 38}, {61, 79, 45}, {34, 60, 88}, {79, 93, 49}, {25, 76, 23},
                {41, 56, 83}, {97, 97, 88}, {13, 57, 71}, {40, 72, 58}, {77, 86, 22}, {41, 41, 94}, {78, 86, 99},
                {36, 81, 5}, {11, 88, 54}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTwoEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
            // 右边最大值
            int[] rightMax = new int[events.length + 1];
            for (int i = events.length - 1; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], events[i][2]);
            }
            int max = -1;
            for (int i = 0; i < events.length; i++) {
                int[] curEvent = events[i];
                int curValue = curEvent[2];
                // 找到下一个开始的位置
                int bs = bs(events, curEvent[1], i);
                if (bs == -1) {
                    // 后面已经没有符合的了
                    max = Math.max(max, curValue);
                    continue;
                }
                // 和后面的最大值加起来
                max = Math.max(max, rightMax[bs] + curValue);
            }
            return max;
        }

        private int bs(int[][] events, int target, int left) {
            int right = events.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int start = events[mid][0];
                if (start > target) {
                    // 向左收缩，mid 可能是答案
                    right = mid;
                } else {
                    // 向右收缩，mid 不可能是答案
                    left = mid + 1;
                }
            }

            return events[right][0] > target ? right : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}