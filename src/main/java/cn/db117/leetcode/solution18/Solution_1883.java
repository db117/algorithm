

//给你一个整数 hoursBefore ，表示你要前往会议所剩下的可用小时数。要想成功抵达会议现场，你必须途经 n 条道路。道路的长度用一个长度为 n 的整数
//数组 dist 表示，其中 dist[i] 表示第 i 条道路的长度（单位：千米）。另给你一个整数 speed ，表示你在道路上前进的速度（单位：千米每小时）。
// 
//
// 当你通过第 i 条路之后，就必须休息并等待，直到 下一个整数小时 才能开始继续通过下一条道路。注意：你不需要在通过最后一条道路后休息，因为那时你已经抵达会
//议现场。 
//
// 
// 例如，如果你通过一条道路用去 1.4 小时，那你必须停下来等待，到 2 小时才可以继续通过下一条道路。如果通过一条道路恰好用去 2 小时，就无需等待，可以
//直接继续。 
// 
//
// 然而，为了能准时到达，你可以选择 跳过 一些路的休息时间，这意味着你不必等待下一个整数小时。注意，这意味着与不跳过任何休息时间相比，你可能在不同时刻到达接
//下来的道路。 
//
// 
// 例如，假设通过第 1 条道路用去 1.4 小时，且通过第 2 条道路用去 0.6 小时。跳过第 1 条道路的休息时间意味着你将会在恰好 2 小时完成通过第
// 2 条道路，且你能够立即开始通过第 3 条道路。 
// 
//
// 返回准时抵达会议现场所需要的 最小跳过次数 ，如果 无法准时参会 ，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：dist = [1,3,2], speed = 4, hoursBefore = 2
//输出：1
//解释：
//不跳过任何休息时间，你将用 (1/4 + 3/4) + (3/4 + 1/4) + (2/4) = 2.5 小时才能抵达会议现场。
//可以跳过第 1 次休息时间，共用 ((1/4 + 0) + (3/4 + 0)) + (2/4) = 1.5 小时抵达会议现场。
//注意，第 2 次休息时间缩短为 0 ，由于跳过第 1 次休息时间，你是在整数小时处完成通过第 2 条道路。
// 
//
// 示例 2： 
//
// 
//输入：dist = [7,3,5,5], speed = 2, hoursBefore = 10
//输出：2
//解释：
//不跳过任何休息时间，你将用 (7/2 + 1/2) + (3/2 + 1/2) + (5/2 + 1/2) + (5/2) = 11.5 小时才能抵达会议现
//场。
//可以跳过第 1 次和第 3 次休息时间，共用 ((7/2 + 0) + (3/2 + 0)) + ((5/2 + 0) + (5/2)) = 10 小时抵达
//会议现场。
// 
//
// 示例 3： 
//
// 
//输入：dist = [7,3,5,5], speed = 1, hoursBefore = 10
//输出：-1
//解释：即使跳过所有的休息时间，也无法准时参加会议。
// 
//
// 
//
// 提示： 
//
// 
// n == dist.length 
// 1 <= n <= 1000 
// 1 <= dist[i] <= 10⁵ 
// 1 <= speed <= 10⁶ 
// 1 <= hoursBefore <= 10⁷ 
// 
//
// Related Topics 数组 动态规划 👍 74 👎 0


package cn.db117.leetcode.solution18;

import java.util.Arrays;

/**
 * 1883.准时抵达会议现场的最小跳过休息次数.minimum-skips-to-arrive-at-meeting-on-time
 *
 * @author db117
 * @since 2024-04-19 20:15:59
 **/

public class Solution_1883 {
    public static void main(String[] args) {
        Solution solution = new Solution_1883().new Solution();
        // [1,3,2]
        //			4
        //			2
        System.out.println(solution.minSkips(new int[]{
                1, 3, 2
        }, 4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dist;
        int speed;
        int[][] memo;

        public int minSkips(int[] dist, int speed, int hoursBefore) {
            int n = dist.length;
            this.dist = dist;
            this.speed = speed;


            memo = new int[n][n + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            for (int i = 0; i <= n; i++) {
                int ans = dfs(n - 2, i) + dist[n - 1];// 最后一条路不需要等待
                if (ans <= (long) speed * hoursBefore) {
                    return i;
                }
            }
            // 无法准时参会
            return -1;
        }

        // 从 0 到 i 跳过 skip 需要的时间 * speed
        private int dfs(int i, int skip) {
            if (i < 0) {
                return 0;
            }
            if (memo[i][skip] != -1) {
                return memo[i][skip];
            }
            // 当前节点不跳过
            // 向上取整（不跳过）
            int ans = (dfs(i - 1, skip) + dist[i] + speed - 1) / speed * speed;
            if (skip > 0) {
                // 当前节点跳过
                ans = Math.min(ans, dfs(i - 1, skip - 1) + dist[i]);// 直接加上距离即可
            }
            return memo[i][skip] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}