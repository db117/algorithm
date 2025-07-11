

//给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。 
//
// 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为
// [startTime[i], endTime[i]] 。 
//
// 你可以重新安排 至多 一个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间
//。 
//
// 请你返回重新安排会议以后，可以得到的 最大 空余时间。 
//
// 注意，会议 不能 安排到整个活动的时间以外，且会议之间需要保持互不重叠。 
//
// 注意：重新安排会议以后，会议之间的顺序可以发生改变。 
//
// 
//
// 示例 1： 
//
// 
// 输入：eventTime = 5, startTime = [1,3], endTime = [2,5] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
//
// 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。 
//
// 示例 2： 
//
// 
// 输入：eventTime = 10, startTime = [0,7,9], endTime = [1,8,10] 
// 
//
// 输出：7 
//
// 解释： 
//
// 
//
// 将 [0, 1] 的会议安排到 [8, 9] ，得到空余时间 [0, 7] 。 
//
// 示例 3： 
//
// 
// 输入：eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10] 
// 
//
// 输出：6 
//
// 解释： 
//
// 
//
// 将 [3, 4] 的会议安排到 [8, 9] ，得到空余时间 [1, 7] 。 
//
// 示例 4： 
//
// 
// 输入：eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5] 
// 
//
// 输出：0 
//
// 解释： 
//
// 活动中的所有时间都被会议安排满了。 
//
// 
//
// 提示： 
//
// 
// 1 <= eventTime <= 10⁹ 
// n == startTime.length == endTime.length 
// 2 <= n <= 10⁵ 
// 0 <= startTime[i] < endTime[i] <= eventTime 
// endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。 
// 
//
// Related Topics 贪心 数组 枚举 👍 23 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3440.重新安排会议得到最多空余时间 II.reschedule-meetings-for-maximum-free-time-ii
 *
 * @author db117
 * @since 2025-07-11 10:11:43
 **/

public class Solution_3440 {
    public static void main(String[] args) {
        Solution solution = new Solution_3440().new Solution();
        // 5
        //			[1,3]
        //			[2,5]
        System.out.println(solution.maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int eventTime;
        int[] startTime;
        int[] endTime;

        public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
            this.eventTime = eventTime;
            this.startTime = startTime;
            this.endTime = endTime;
            int n = startTime.length;
            // 找前三大空间的位置
            int a = 0;
            int b = -1;
            int c = -1;
            for (int i = 1; i <= n; i++) {
                int fz = freeSize(i);
                if (fz > freeSize(a)) {
                    c = b;
                    b = a;
                    a = i;
                } else if (b < 0 || fz > freeSize(b)) {
                    c = b;
                    b = i;
                } else if (c < 0 || fz > freeSize(c)) {
                    c = i;
                }
            }

            int ans = 0;
            // 枚举会议
            for (int i = 0; i < n; i++) {
                int size = endTime[i] - startTime[i];
                if ((i != a && i + 1 != a && size <= freeSize(a)) ||
                        (i != b && i + 1 != b && size <= freeSize(b)) ||
                        size <= freeSize(c)) {
                    // 会议可以移出去
                    ans = Math.max(ans, freeSize(i) + freeSize(i + 1) + size);
                } else {
                    // 不能移动出去，那么就往两边移动
                    ans = Math.max(ans, freeSize(i) + freeSize(i + 1));
                }
            }
            return ans;
        }


        // 第几个空位的长度
        int freeSize(int i) {
            if (i == 0) {
                return startTime[0];
            }
            if (i == startTime.length) {
                return eventTime - endTime[startTime.length - 1];
            }
            return startTime[i] - endTime[i - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}