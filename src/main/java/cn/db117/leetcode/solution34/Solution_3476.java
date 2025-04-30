

//给定一个整数数组 workers，其中 workers[i] 表示第 i 个工人的技能等级。同时给定一个 2 维数组 tasks，其中： 
//
// 
// tasks[i][0] 表示完成任务所需的技能要求。 
// tasks[i][1] 表示完成任务的收益。 
// 
//
// 每一个工人 最多 能完成一个任务，并且只有在他们的技能等级 等于 任务的技能要求时才能获取此任务。今天又有一名 额外 工人加入，他可以承接任何任务，无论 
//技能要求如何。 
//
// 返回按照最优方式分配任务给工人所能获得的 最大 总利润。 
//
// 
//
// 示例 1： 
//
// 
// 输入：workers = [1,2,3,4,5], tasks = [[1,100],[2,400],[3,100],[3,400]] 
// 
//
// 输出：1000 
//
// 解释： 
//
// 
// 工人 0 完成任务 0。 
// 工人 1 完成任务 1。 
// 工人 2 完成任务 3。 
// 额外工人完成任务 2。 
// 
//
// 示例 2： 
//
// 
// 输入：workers = [10,10000,100000000], tasks = [[1,100]] 
// 
//
// 输出：100 
//
// 解释： 
//
// 由于没有工人满足技能需求，只有额外工人能够完成任务 0。 
//
// 示例 3： 
//
// 
// 输入：workers = [7], tasks = [[3,3],[3,3]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 额外工人完成任务 1。由于没有任务的技能需求为 7，工人 0 无法工作。 
//
// 
//
// 提示： 
//
// 
// 1 <= workers.length <= 10⁵ 
// 1 <= workers[i] <= 10⁹ 
// 1 <= tasks.length <= 10⁵ 
// tasks[i].length == 2 
// 1 <= tasks[i][0], tasks[i][1] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 0 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3476.最大化任务分配的利润.maximize-profit-from-task-assignment
 *
 * @author db117
 * @since 2025-04-30 11:28:00
 **/

public class Solution_3476 {
    public static void main(String[] args) {
        Solution solution = new Solution_3476().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxProfit(int[] workers, int[][] tasks) {
            long ans = 0;
            Map<Integer, Integer> count = new HashMap<>();
            for (int worker : workers) {
                count.put(worker, count.getOrDefault(worker, 0) + 1);
            }
            // 按价值排序
            Arrays.sort(tasks, (o1, o2) -> o2[1] - o1[1]);
            int max = 0;// 多出来的价值最大的技能
            for (int[] task : tasks) {
                if (count.getOrDefault(task[0], 0) > 0) {
                    // 有对应的技能的工人
                    ans += task[1];
                    count.put(task[0], count.getOrDefault(task[0], 0) - 1);
                } else {
                    // 没有找到对应技能的工人
                    max = Math.max(max, task[1]);
                }
            }
            return ans + max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}