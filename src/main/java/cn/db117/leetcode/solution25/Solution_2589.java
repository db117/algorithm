

//你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, 
//durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。 
//
// 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。 
//
// 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。 
//
// 
//
// 示例 1： 
//
// 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
//输出：2
//解释：
//- 第一个任务在闭区间 [2, 2] 运行。
//- 第二个任务在闭区间 [5, 5] 运行。
//- 第三个任务在闭区间 [2, 2] 和 [5, 5] 运行。
//电脑总共运行 2 个整数时间点。
// 
//
// 示例 2： 
//
// 输入：tasks = [[1,3,2],[2,5,3],[5,6,2]]
//输出：4
//解释：
//- 第一个任务在闭区间 [2, 3] 运行
//- 第二个任务在闭区间 [2, 3] 和 [5, 5] 运行。
//- 第三个任务在闭区间 [5, 6] 运行。
//电脑总共运行 4 个整数时间点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 2000 
// tasks[i].length == 3 
// 1 <= starti, endi <= 2000 
// 1 <= durationi <= endi - starti + 1 
// 
//
// Related Topics 栈 贪心 数组 二分查找 排序 👍 20 👎 0


package cn.db117.leetcode.solution25;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2589.完成所有任务的最少时间.minimum-time-to-complete-all-tasks
 *
 * @author db117
 * @since 2023-03-14 15:26:29
 **/

public class Solution_2589 {
    public static void main(String[] args) {
        Solution solution = new Solution_2589().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinimumTime(int[][] tasks) {
            int n = tasks.length;
            // 按照结束时间排序，则当前区间要么和后面区间没有关系，要么后面包含当前区间后缀
            Arrays.sort(tasks, Comparator.comparing(o -> o[1]));
            // 记录是否运行
            boolean[] flag = new boolean[tasks[n - 1][1] + 1];

            for (int[] task : tasks) {
                // 计算当前区间已经运行的数量
                int cur = 0;
                for (int j = task[0]; j <= task[1]; j++) {
                    if (flag[j]) {
                        cur++;
                    }
                }

                if (task[2] <= cur) {
                    continue;
                }
                // 如果不够从后面一个个运行，可以让后面尽可能的用到当前区间
                cur = task[2] - cur;
                for (int j = task[1]; j >= task[0] && cur > 0; j--) {
                    if (flag[j]) {
                        continue;
                    }
                    flag[j] = true;
                    cur--;
                }
            }

            // 统计
            int ans = 0;
            for (boolean b : flag) {
                if (b) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}