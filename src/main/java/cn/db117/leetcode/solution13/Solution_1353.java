

//给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 
//endDayi 。 
//
// 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。 
//
// 请你返回你可以参加的 最大 会议数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：events = [[1,2],[2,3],[3,4]]
//输出：3
//解释：你可以参加所有的三个会议。
//安排会议的一种方案如上图。
//第 1 天参加第一个会议。
//第 2 天参加第二个会议。
//第 3 天参加第三个会议。
// 
//
// 示例 2： 
//
// 
//输入：events= [[1,2],[2,3],[3,4],[1,2]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= events.length <= 10⁵ 
// events[i].length == 2 
// 1 <= startDayi <= endDayi <= 10⁵ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 327 👎 0


package cn.db117.leetcode.solution13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1353.最多可以参加的会议数目.maximum-number-of-events-that-can-be-attended
 *
 * @author db117
 * @since 2025-07-07 19:10:45
 **/

public class Solution_1353 {
    public static void main(String[] args) {
        Solution solution = new Solution_1353().new Solution();
        // [[1,2],[2,3],[3,4]]
        System.out.println(solution.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEvents(int[][] events) {
            // 按照天走，优先参加结束时间最早的会员。
            int ans = 0;
            // 按开始时间排序
            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int j = 0;
            for (int i = 0; i < 100007; i++) {
                // 添加已经开始的会议
                while (j < events.length && events[j][0] <= i) {
                    pq.add(events[j++][1]);
                }
                // 移除已经结束的会议
                while (!pq.isEmpty() && pq.peek() < i) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    // 参加一个结束时间最早的会议
                    pq.poll();
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}