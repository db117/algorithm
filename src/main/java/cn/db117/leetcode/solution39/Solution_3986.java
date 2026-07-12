

//给你两个有效时间 startTime 和 endTime，它们均以字符串形式表示，格式为 "HH:MM:SS"。 
//
// 返回从 startTime 到 endTime 经过的秒数（包含两个端点）。 
//
// 
//
// 示例 1： 
//
// 
// 输入： startTime = "01:00:00", endTime = "01:00:25" 
// 
//
// 输出： 25 
//
// 解释： 
//
// endTime 比 startTime 晚 25 秒。 
//
// 示例 2： 
//
// 
// 输入： startTime = "12:34:56", endTime = "13:00:00" 
// 
//
// 输出： 1504 
//
// 解释： 
//
// endTime 比 startTime 晚 25 分 4 秒，共计 1504 秒。 
//
// 
//
// 提示： 
//
// 
// startTime.length == 8 
// endTime.length == 8 
// startTime 和 endTime 均为格式 "HH:MM:SS" 的有效时间 
// 00 <= HH <= 23 
// 00 <= MM <= 59 
// 00 <= SS <= 59 
// endTime 不早于 startTime 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution39;

/**
 * 3986.统计起止时间经过的秒数.number-of-elapsed-seconds-between-two-times
 *
 * @author db117
 * @since 2026-07-12 16:27:29
 **/

public class Solution_3986 {
    public static void main(String[] args) {
        Solution solution = new Solution_3986().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondsBetweenTimes(String startTime, String endTime) {
            return helper(endTime) - helper(startTime);
        }

        int helper(String time) {
            String[] split = time.split(":");
            return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}