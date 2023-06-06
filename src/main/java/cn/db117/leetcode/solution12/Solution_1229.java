

//给定两个人的空闲时间表：slots1 和 slots2，以及会议的预计持续时间 duration，请你为他们安排 时间段最早 且合适的会议时间。 
//
// 如果没有满足要求的会议时间，就请返回一个 空数组。 
//
// 「空闲时间」的格式是 [start, end]，由开始时间 start 和结束时间 end 组成，表示从 start 开始，到 end 结束。 
//
// 题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 [start1, end1] 和 [start2, end2
//]，要么 start1 > end2，要么 start2 > end1。 
//
// 
//
// 示例 1： 
//
// 
//输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration 
//= 8
//输出：[60,68]
// 
//
// 示例 2： 
//
// 
//输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration 
//= 12
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slots1.length, slots2.length <= 10⁴ 
// slots1[i].length, slots2[i].length == 2 
// slots1[i][0] < slots1[i][1] 
// slots2[i][0] < slots2[i][1] 
// 0 <= slots1[i][j], slots2[i][j] <= 10⁹ 
// 1 <= duration <= 10⁶ 
// 
//
// Related Topics 数组 双指针 排序 👍 69 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1229.安排会议日程.meeting-scheduler
 *
 * @author db117
 * @since 2023-06-06 11:08:18
 **/

public class Solution_1229 {
    public static void main(String[] args) {
        Solution solution = new Solution_1229().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
            Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));

            int len1 = slots1.length;
            int len2 = slots2.length;
            int i1 = 0, i2 = 0;
            while (i1 < len1 && i2 < len2) {
                // 不相交
                if (slots1[i1][1] < slots2[i2][0]) {
                    i1++;
                    continue;
                }
                if (slots2[i2][1] < slots1[i1][0]) {
                    i2++;
                    continue;
                }
                // 肯定相交了
                int start = Math.max(slots1[i1][0], slots2[i2][0]);
                int end = Math.min(slots1[i1][1], slots2[i2][1]);
                int diff = end - start;
                if (diff >= duration) {
                    // 找到了
                    ans.add(start);
                    ans.add(start + duration);
                    return ans;
                }
                // 把时间段结束时间小的去掉
                if (slots1[i1][1] == end) {
                    i1++;
                } else {
                    i2++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}