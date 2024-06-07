

//给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [
//start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。 
//
// 返回员工可工作且没有安排会议的天数。 
//
// 注意：会议时间可能会有重叠。 
//
// 
//
// 示例 1： 
//
// 
// 输入：days = 10, meetings = [[5,7],[1,3],[9,10]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 第 4 天和第 8 天没有安排会议。 
//
// 示例 2： 
//
// 
// 输入：days = 5, meetings = [[2,4],[1,3]] 
// 
//
// 输出：1 
//
// 解释： 
//
// 第 5 天没有安排会议。 
//
// 示例 3： 
//
// 
// 输入：days = 6, meetings = [[1,6]] 
// 
//
// 输出：0 
//
// 解释： 
//
// 所有工作日都安排了会议。 
//
// 
//
// 提示： 
//
// 
// 1 <= days <= 10⁹ 
// 1 <= meetings.length <= 10⁵ 
// meetings[i].length == 2 
// 1 <= meetings[i][0] <= meetings[i][1] <= days 
// 
//
// Related Topics 数组 排序 👍 4 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;

/**
 * 3169.无需开会的工作日.count-days-without-meetings
 *
 * @author db117
 * @since 2024-06-07 16:33:51
 **/

public class Solution_3169 {
    public static void main(String[] args) {
        Solution solution = new Solution_3169().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDays(int days, int[][] meetings) {
            // 按照会议时间排序
            Arrays.sort(meetings, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            int pre = 0;
            int ans = 0;
            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];
                if (start > pre) {
                    // 空闲的时间
                    ans += start - pre - 1;
                }
                // 更新最后一个会议的结束时间
                pre = Math.max(pre, end);
            }

            // 剩余的时间
            if (pre < days) {
                ans += days - pre;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}