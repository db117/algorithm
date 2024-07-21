

//给你两个长度为 n 下标从 0 开始的整数数组 cost 和 time ，分别表示给 n 堵不同的墙刷油漆需要的开销和时间。你有两名油漆匠： 
//
// 
// 一位需要 付费 的油漆匠，刷第 i 堵墙需要花费 time[i] 单位的时间，开销为 cost[i] 单位的钱。 
// 一位 免费 的油漆匠，刷 任意 一堵墙的时间为 1 单位，开销为 0 。但是必须在付费油漆匠 工作 时，免费油漆匠才会工作。 
// 
//
// 请你返回刷完 n 堵墙最少开销为多少。 
//
// 
//
// 示例 1： 
//
// 输入：cost = [1,2,3,2], time = [1,2,3,2]
//输出：3
//解释：下标为 0 和 1 的墙由付费油漆匠来刷，需要 3 单位时间。同时，免费油漆匠刷下标为 2 和 3 的墙，需要 2 单位时间，开销为 0 。总开销为 
//1 + 2 = 3 。
// 
//
// 示例 2： 
//
// 输入：cost = [2,3,4,2], time = [1,1,1,1]
//输出：4
//解释：下标为 0 和 3 的墙由付费油漆匠来刷，需要 2 单位时间。同时，免费油漆匠刷下标为 1 和 2 的墙，需要 2 单位时间，开销为 0 。总开销为 
//2 + 2 = 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= cost.length <= 500 
// cost.length == time.length 
// 1 <= cost[i] <= 10⁶ 
// 1 <= time[i] <= 500 
// 
//
// Related Topics 数组 动态规划 👍 69 👎 0


package cn.db117.leetcode.solution27;

/**
 * 2742.给墙壁刷油漆.painting-the-walls
 *
 * @author db117
 * @since 2024-06-28 14:40:58
 **/

public class Solution_2742 {
    public static void main(String[] args) {
        Solution solution = new Solution_2742().new Solution();
        // [1,2,3,2]
        //			[1,2,3,2]
        System.out.println(solution.paintWalls(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2}));

        // 		[2,3,4,2]
        //			[1,1,1,1].
        System.out.println(solution.paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cost;
        int[] time;
        int[][] memo;
        int n;

        public int paintWalls(int[] cost, int[] time) {
            this.cost = cost;
            this.time = time;
            n = cost.length;
            memo = new int[n][2 * n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2 * n + 1; j++) {
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }
            return dfs(n - 1, 0);
        }

        /**
         * @param i 第几堵墙
         * @param j 付费时间和 - 免费时间和
         */
        private int dfs(int i, int j) {
            if (i < j) {
                // 剩下的墙都可以免翻刷
                return 0;
            }
            if (i < 0) {
                // 前面已经判断了，到这里来就说明刷不了了
                return Integer.MAX_VALUE / 2;
            }
            // j 需要加上 n ，防止溢出
            if (memo[i][j + n] != Integer.MAX_VALUE) {
                return memo[i][j + n];
            }
            int ans = Integer.MAX_VALUE;
            // 付费
            ans = Math.min(ans, cost[i] + dfs(i - 1, j + time[i]));
            // 免费
            ans = Math.min(ans, dfs(i - 1, j - 1));

            return memo[i][j + n] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}