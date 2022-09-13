

//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 
//所需会议室的最小数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
//
// Related Topics 贪心 数组 双指针 排序 堆（优先队列） 👍 468 👎 0


package cn.db117.leetcode.solution2;

import java.util.Map;
import java.util.TreeMap;

/**
 * 253.会议室 II.meeting-rooms-ii
 *
 * @author db117
 * @see cn.db117.template.DiffArray
 * @since 2022-09-13 18:09:13
 **/

public class Solution_253 {
    public static void main(String[] args) {
        Solution solution = new Solution_253().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            // 差分数组
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int[] interval : intervals) {
                treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
                treeMap.put(interval[1], treeMap.getOrDefault(interval[1], 0) - 1);
            }

            int max = 0;
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                Integer count = entry.getValue();
                sum += count;
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}