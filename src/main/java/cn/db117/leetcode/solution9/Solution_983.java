

//在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 36
//5 的整数。 
//
// 火车票有 三种不同的销售方式 ： 
//
// 
// 一张 为期一天 的通行证售价为 costs[0] 美元； 
// 一张 为期七天 的通行证售价为 costs[1] 美元； 
// 一张 为期三十天 的通行证售价为 costs[2] 美元。 
// 
//
// 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天
//、第 5 天、第 6 天、第 7 天和第 8 天。 
//
// 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。 
//
// 
//
// 示例 1： 
//
// 
//输入：days = [1,4,6,7,8,20], costs = [2,7,15]
//输出：11
//解释： 
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
//在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
//在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
//在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
//你总共花了 $11，并完成了你计划的每一天旅行。
// 
//
// 示例 2： 
//
// 
//输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//输出：17
//解释：
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 
//在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
//在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。 
//你总共花了 $17，并完成了你计划的每一天旅行。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days.length <= 365 
// 1 <= days[i] <= 365 
// days 按顺序严格递增 
// costs.length == 3 
// 1 <= costs[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 641 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 983.最低票价.minimum-cost-for-tickets
 *
 * @author db117
 * @since 2024-10-01 23:36:28
 **/

public class Solution_983 {
    public static void main(String[] args) {
        Solution solution = new Solution_983().new Solution();
        // [1,4,6,7,8,20]
        //			[2,7,15]
        System.out.println(solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));

        // [2,7,8,10,12,13,14,17,25,28,29,34,35,37,43,44,45,53,54,58,60,61,62,63,64,65,66,71,74,82,86,88,95,97,98,102,105,106,115,117,119,120,125,129,135,136,142,143,152,153,155,158,165,166,168,181,187,189,191,192,193,194,196,197,198,201,208,209,211,212,215,224,226,236,242,243,244,245,248,252,260,261,263,266,269,272,273,274,280,284,286,287,292,297,300,303,304,312,317,323,326,328,329,332,333,337,341,348,349,351,352,355,361,364]
        //			[16,82,359]
        System.out.println(solution.mincostTickets(new int[]{2, 7, 8, 10, 12, 13, 14, 17, 25, 28, 29, 34, 35, 37, 43, 44, 45, 53, 54, 58, 60, 61, 62, 63, 64, 65, 66, 71, 74, 82, 86, 88, 95, 97, 98, 102, 105, 106, 115, 117, 119, 120, 125, 129, 135, 136, 142, 143, 152, 153, 155, 158, 165, 166, 168, 181, 187, 189, 191, 192, 193, 194, 196, 197, 198, 201, 208, 209, 211, 212, 215, 224, 226, 236, 242, 243, 244, 245, 248, 252, 260, 261, 263, 266, 269, 272, 273, 274, 280, 284, 286, 287, 292, 297, 300, 303, 304, 312, 317, 323, 326, 328, 329, 332, 333, 337, 341, 348, 349, 351, 352, 355, 361, 364}, new int[]{16, 82, 359}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] days;
        int[] costs;
        TreeSet<Integer> set = new TreeSet<>();
        int[] dp;

        public int mincostTickets(int[] days, int[] costs) {
            this.days = days;
            this.costs = costs;
            for (int day : days) {
                set.add(day);
            }
            dp = new int[366];
            Arrays.fill(dp, -1);

            return dfs(days[days.length - 1]);
        }

        private int dfs(int day) {
            if (day <= 0) {
                return 0;
            }
            // 前面最近的日期
            Integer floor = set.floor(day);
            if (floor == null) {
                return 0;
            }
            // 前面有效的日期
            day = floor;

            if (dp[day] != -1) {
                return dp[day];
            }

            // 1
            int ans = dfs(day - 1) + costs[0];
            // 7
            ans = Math.min(ans, dfs(day - 7) + costs[1]);
            // 30
            ans = Math.min(ans, dfs(day - 30) + costs[2]);

            return dp[day] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}