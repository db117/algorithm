

//你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。第 i 个机器人充电时间
//为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。 
//
// 运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，其中 max(chargeTimes)
// 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。 
//
// 请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。 
//
// 
//
// 示例 1： 
//
// 
//输入：chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
//输出：3
//解释：
//可以在 budget 以内运行所有单个机器人或者连续运行 2 个机器人。
//选择前 3 个机器人，可以得到答案最大值 3 。总开销是 max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 ，小于 
//25 。
//可以看出无法在 budget 以内连续运行超过 3 个机器人，所以我们返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
//输出：0
//解释：即使运行任何一个单个机器人，还是会超出 budget，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// chargeTimes.length == runningCosts.length == n 
// 1 <= n <= 5 * 10⁴ 
// 1 <= chargeTimes[i], runningCosts[i] <= 10⁵ 
// 1 <= budget <= 10¹⁵ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 堆（优先队列） 👍 52 👎 0


package cn.db117.leetcode.solution23;

import java.util.TreeMap;

/**
 * 2398.预算内的最多机器人数目.maximum-number-of-robots-within-budget
 *
 * @author db117
 * @since 2024-09-13 10:24:07
 **/

public class Solution_2398 {
    public static void main(String[] args) {
        Solution solution = new Solution_2398().new Solution();
        // [3,6,1,3,4]
        //			[2,1,3,4,5]
        //			25
//        System.out.println(solution.maximumRobots(new int[]{3, 6, 1, 3, 4}, new int[]{2, 1, 3, 4, 5}, 25));

        // [11,12,19]
        //			[10,8,7]
        //			19
        System.out.println(solution.maximumRobots(new int[]{11, 12, 19}, new int[]{10, 8, 7}, 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] chargeTimes;
        int[] runningCosts;
        long budget;

        public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
            this.chargeTimes = chargeTimes;
            this.runningCosts = runningCosts;
            this.budget = budget;

            int left = 0, right = chargeTimes.length;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (check(mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        boolean check(int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            long sumCost = 0;
            for (int i = 0; i < chargeTimes.length; i++) {
                sumCost += runningCosts[i];
                map.put(chargeTimes[i], map.getOrDefault(chargeTimes[i], 0) + 1);
                if (i >= k) {
                    sumCost -= runningCosts[i - k];
                    map.put(chargeTimes[i - k], map.get(chargeTimes[i - k]) - 1);
                    while (map.get(map.lastKey()) <= 0) {
                        map.remove(map.lastKey());
                    }
                }
                if (i >= k - 1 && map.lastEntry().getKey() + k * sumCost <= budget) {
                    return true;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}