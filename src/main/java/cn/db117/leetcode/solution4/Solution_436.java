


//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。 
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。 
//
// 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1, 0, 1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1, 2, -1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 2 * 104 
// intervals[i].length == 2 
// -106 <= starti <= endi <= 106 
// 每个间隔的起点都 不相同 
// 
// Related Topics 数组 二分查找 排序 
// 👍 74 👎 0


package cn.db117.leetcode.solution4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 436.寻找右区间.find-right-interval
 *
 * @author db117
 * @since 2021-07-05 17:13:17
 **/

public class Solution_436 {
    public static void main(String[] args) {
        Solution solution = new Solution_436().new Solution();
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{
                {3, 4}, {2, 3}, {1, 2}
        })));
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{
                {1, 4}, {2, 3}, {3, 4}
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            // 区间左边界 -》 索引位置
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < intervals.length; i++) {
                map.put(intervals[i][0], i);
            }
            // 对源数组排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            // 遍历 二分
            int[] ans = new int[intervals.length];
            for (int[] interval : intervals) {
                // 找到下一个区间开始左边界
                int start = bs(intervals, interval[1]);

                //  当前区间原始索引位置
                Integer index = map.get(interval[0]);
                if (start != -1) {
                    ans[index] = map.get(intervals[start][0]);
                } else {
                    ans[index] = -1;
                }
            }
            return ans;
        }

        // 找到目标值，比目标大的最小值
        private int bs(int[][] intervals, int target) {
            int left = 0, right = intervals.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int start = intervals[mid][0];
                if (start == target) {
                    return mid;
                } else if (start < target) {
                    // 缩小左边界
                    left = mid + 1;
                } else {
                    // 当当前值是比目标值大 的最小值是
                    if (mid > 0 && intervals[mid - 1][0] < target) {
                        return mid;
                    }

                    // 缩小右边界
                    right = mid;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}