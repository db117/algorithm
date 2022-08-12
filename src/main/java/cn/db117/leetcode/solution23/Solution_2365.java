

//给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。 
//
// 同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。 
//
// 在所有任务完成前的每一天，你都必须进行以下两种操作中的一种： 
//
// 
// 完成 tasks 中的下一个任务 
// 休息一天 
// 
//
// 请你返回完成所有任务所需的 最少 天数。 
//
// 
//
// 示例 1： 
//
// 输入：tasks = [1,2,1,2,3,1], space = 3
//输出：9
//解释：
//9 天完成所有任务的一种方法是：
//第 1 天：完成任务 0 。
//第 2 天：完成任务 1 。
//第 3 天：休息。
//第 4 天：休息。
//第 5 天：完成任务 2 。
//第 6 天：完成任务 3 。
//第 7 天：休息。
//第 8 天：完成任务 4 。
//第 9 天：完成任务 5 。
//可以证明无法少于 9 天完成所有任务。
// 
//
// 示例 2： 
//
// 输入：tasks = [5,8,8,5], space = 2
//输出：6
//解释：
//6 天完成所有任务的一种方法是：
//第 1 天：完成任务 0 。
//第 2 天：完成任务 1 。
//第 3 天：休息。
//第 4 天：休息。
//第 5 天：完成任务 2 。
//第 6 天：完成任务 3 。
//可以证明无法少于 6 天完成所有任务。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 10⁵ 
// 1 <= tasks[i] <= 10⁹ 
// 1 <= space <= tasks.length 
// 
//
// Related Topics 数组 哈希表 模拟 👍 5 👎 0


package cn.db117.leetcode.solution23;

import java.util.HashMap;
import java.util.Map;

/**
 * 2365.任务调度器 II.task-scheduler-ii
 *
 * @author db117
 * @since 2022-08-12 17:41:40
 **/

public class Solution_2365 {
    public static void main(String[] args) {
        Solution solution = new Solution_2365().new Solution();

        System.out.println(solution.taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long taskSchedulerII(int[] tasks, int space) {
            // 任务类型 -> 下一次能干的天数
            Map<Integer, Long> cache = new HashMap<>();

            long ans = 0;
            for (int task : tasks) {
                // 当前任务能执行的时间
                Long next = cache.getOrDefault(task, 0L);
                if (ans >= next) {
                    // 可以执行
                    ans++;
                } else {
                    // 不能执行,就在可以执行的时间+一天执行的时间
                    ans = cache.get(task) + 1;
                }
                // 当前任务下一次能执行的时间
                cache.put(task, ans + space);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}